// Select elements
const canvas = document.getElementById('whiteboard-canvas');
const ctx = canvas.getContext('2d');
let currentShape = '';
let undoStack = [], redoStack = [];

// Set canvas full size
canvas.width = window.innerWidth * 0.8;
canvas.height = window.innerHeight * 0.9;

// Event listeners
document.getElementById('rectangle-icon').addEventListener('click', function() {
    currentShape = 'rectangle';
});
document.getElementById('circle-icon').addEventListener('click', function() {
    currentShape = 'circle';
});
document.getElementById('triangle-icon').addEventListener('click', function() {
    currentShape = 'triangle';
});

document.getElementById('clear-canvas').addEventListener('click', function() {
    ctx.clearRect(0, 0, canvas.width, canvas.height);
    undoStack = [];
    redoStack = [];
});

// Drawing state
let drawing = false;
let startX, startY;

// Mouse event listeners
canvas.addEventListener('mousedown', startDrawing);
canvas.addEventListener('mousemove', drawShape);
canvas.addEventListener('mouseup', stopDrawing);

function startDrawing(e) {
    drawing = true;
    startX = e.offsetX;
    startY = e.offsetY;
    saveState(); // Save the current state of the canvas
}

function drawShape(e) {
    if (!drawing) return;
    const currentX = e.offsetX;
    const currentY = e.offsetY;

    // Restore the saved state of the canvas
    restoreState();

    ctx.beginPath();
    ctx.lineWidth = 15;

    switch (currentShape) {
        case 'rectangle':
            drawRectangle(ctx, startX, startY, currentX - startX, currentY - startY);
            break;
        case 'circle':
            drawCircle(ctx, startX, startY, currentX, currentY);
            break;
        case 'triangle':
            drawTriangle(ctx, startX, startY, currentX, currentY);
            break;
        default:
            break;
    }
}

function stopDrawing() {
    drawing = false;
}

// Restore
function restoreState() {
    if (undoStack.length > 0) {
        ctx.putImageData(undoStack[undoStack.length - 1], 0, 0);
    }
}
// Shape drawing functions
function drawRectangle(ctx, x, y, width, height) {
    ctx.rect(x, y, width, height);
    ctx.stroke();
}

function drawCircle(ctx, startX, startY, endX, endY) {
    let radius = Math.sqrt(Math.pow(endX - startX, 2) + Math.pow(endY - startY, 2));
    ctx.arc(startX, startY, radius, 0, Math.PI * 2);
    ctx.stroke();
}

function drawTriangle(ctx, startX, startY, endX, endY) {
    ctx.moveTo(startX, startY);
    ctx.lineTo(endX, startY);
    ctx.lineTo((startX + endX) / 2, endY);
    ctx.closePath();
    ctx.stroke();
}

document.getElementById('undo').addEventListener('click', undoLastAction);
document.getElementById('redo').addEventListener('click', redoLastAction);

// Logout button
document.getElementById('logout').addEventListener('click', function() {
    window.location.href = 'index.html'; // Redirect to login page
});

// Save canvas state to stack
function saveState() {
    undoStack.push(ctx.getImageData(0, 0, canvas.width, canvas.height));
    redoStack = []; // Clear redo stack
}

function undoLastAction() {
    if (undoStack.length > 0) {
        redoStack.push(ctx.getImageData(0, 0, canvas.width, canvas.height));
        ctx.putImageData(undoStack.pop(), 0, 0);
    }
}

function redoLastAction() {
    if (redoStack.length > 0) {
        undoStack.push(ctx.getImageData(0, 0, canvas.width, canvas.height));
        ctx.putImageData(redoStack.pop(), 0, 0);
    }
}


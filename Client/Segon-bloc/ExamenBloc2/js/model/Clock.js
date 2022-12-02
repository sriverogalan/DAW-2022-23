class Clock {
  _constructor() {}

  static getInstance() {
    if (!this._instance) {
      this._instance = new CanalService();
    } 
    return this._instance;
  }

  static init = () => {
    canvas = document.getElementById("canvas");
    ctx = canvas.getContext("2d");
    radius = canvas.height / 2;
    ctx.translate(radius, radius);
    radius = radius * 0.9;
    drawClock(ctx, radius);
  };

  static drawClock= () => {
    ctx.font = radius * 0.25 + "px 'Butterfly Kids', cursive";
    drawFace(ctx, radius);
    drawNumbers(ctx, radius);
    drawTime(ctx, radius);
  }
  static drawFace= (ctx, radius) => {
    var grad;
    ctx.beginPath();
    ctx.arc(0, 0, radius, 0, 2 * Math.PI);
    ctx.fillStyle = "white";
    ctx.fill();
    grad = ctx.createRadialGradient(0, 0, radius * 0.95, 0, 0, radius * 1.05);
    grad.addColorStop(0, "#333");
    grad.addColorStop(0.5, "white");
    grad.addColorStop(1, "#333");
    ctx.strokeStyle = grad;
    ctx.lineWidth = radius * 0.1;
    ctx.stroke();
    ctx.beginPath();
    ctx.arc(0, 0, radius * 0.1, 0, 2 * Math.PI);
    ctx.fillStyle = "#333";
    ctx.fill();
  }

  static drawNumbers= (ctx, radius) =>{
    var ang;
    var num;
    ctx.textBaseline = "middle";
    ctx.textAlign = "center";
    for (num = 1; num < 13; num++) {
      ang = (num * Math.PI) / 6;
      ctx.rotate(ang);
      ctx.translate(0, -radius * 0.85);
      ctx.rotate(-ang);
      ctx.fillText(num.toString(), 0, 0);
      ctx.rotate(ang);
      ctx.translate(0, radius * 0.85);
      ctx.rotate(-ang);
    }
  }

  static drawTime= (ctx, radius) => {
    var hour = document.querySelector("#hours").value;
    var minute = document.querySelector("#minutes").value;
    var second = document.querySelector("#seconds").value;
    //hour
    hour = hour % 12;
    hour =
      (hour * Math.PI) / 6 +
      (minute * Math.PI) / (6 * 60) +
      (second * Math.PI) / (360 * 60);
    drawHand(ctx, hour, radius * 0.5, radius * 0.07);
    //minute
    minute = (minute * Math.PI) / 30 + (second * Math.PI) / (30 * 60);
    drawHand(ctx, minute, radius * 0.8, radius * 0.07);
    // second
    second = (second * Math.PI) / 30;
    drawHand(ctx, second, radius * 0.9, radius * 0.02);
  }

  static drawHand = (ctx, pos, length, width) => {
    ctx.beginPath();
    ctx.lineWidth = width;
    ctx.lineCap = "round";
    ctx.moveTo(0, 0);
    ctx.rotate(pos);
    ctx.lineTo(0, -length);
    ctx.stroke();
    ctx.rotate(-pos);
  }
}

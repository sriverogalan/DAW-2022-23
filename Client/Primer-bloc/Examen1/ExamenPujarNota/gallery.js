var img = new Image()
img.crossOrigin = 'anonymous'
img.id = 'featuredimage'
img.src = 'https://images.pexels.com/photos/4164418/pexels-photo-4164418.jpeg'

var canvas = document.getElementById('canvas')
var ctx = canvas.getContext('2d')

img.onload = function () {
  resizeImage()
}

function resizeImage() {
  canvas.width = 400
  canvas.height = 300

  var w = img.width
  var h = img.height

  // resize img to fit in the canvas
  // You can alternately request img to fit into any specified width/height
  var sizer = scalePreserveAspectRatio(w, h, canvas.width, canvas.height)

  ctx.drawImage(img, 0, 0, w, h, 0, 0, w * sizer, h * sizer)
}

function scalePreserveAspectRatio(imgW, imgH, maxW, maxH) {
  return Math.min(maxW / imgW, maxH / imgH)
}

function setImage(url) {
  img.src = url
  resizeImage()
}

var original = function () {
  resizeImage()
}

var sepia = function () {
  resizeImage()
  const imageData = ctx.getImageData(0, 0, canvas.width, canvas.height)
  const data = imageData.data
  for (var i = 0; i < data.length; i += 4) {
    let red = data[i],
      green = data[i + 1],
      blue = data[i + 2]

    data[i] = Math.min(
      Math.round(0.393 * red + 0.769 * green + 0.189 * blue),
      255,
    )
    data[i + 1] = Math.min(
      Math.round(0.349 * red + 0.686 * green + 0.168 * blue),
      255,
    )
    data[i + 2] = Math.min(
      Math.round(0.272 * red + 0.534 * green + 0.131 * blue),
      255,
    )
  }
  ctx.putImageData(imageData, 0, 0)
}

var invert = function () {
  resizeImage()
  const imageData = ctx.getImageData(0, 0, canvas.width, canvas.height)
  const data = imageData.data
  for (var i = 0; i < data.length; i += 4) {
    data[i] = 255 - data[i] // red
    data[i + 1] = 255 - data[i + 1] // green
    data[i + 2] = 255 - data[i + 2] // blue
  }
  ctx.putImageData(imageData, 0, 0)
}

var grayscale = function () {
  resizeImage()
  const imageData = ctx.getImageData(0, 0, canvas.width, canvas.height)
  const data = imageData.data
  for (var i = 0; i < data.length; i += 4) {
    var avg = (data[i] + data[i + 1] + data[i + 2]) / 3
    data[i] = avg // red
    data[i + 1] = avg // green
    data[i + 2] = avg // blue
  }
  ctx.putImageData(imageData, 0, 0)
}


/// AQUI COMENÇA
document.querySelector('#original').addEventListener('click', original)
document.querySelector('#sepia').addEventListener('click', sepia)
document.querySelector('#inverted').addEventListener('click', invert)
document.querySelector('#grayscale').addEventListener('click', grayscale)

function Galeria(img) {
  this.img = img

  this.mostrar = function () {
    document.querySelector('#contain').innerHTML += `
        <div class="four columns item">
        <div class="caption">
            <img src="${this.img}" alt="" class="pic"/>
        </div>
        <h4>{TITOL DE L'ENTRADA}</h4>
        <p>Publicat el {DATA DE L'ENTRADA}</p>
    </div>`
  }
}

let arrayGaleries = []

document.querySelectorAll('#contain .item').forEach((div) => {
  let img = div.querySelector('img').src
  let galeria = new Galeria(img)
  arrayGaleries.push(galeria)
})

document.querySelector('#contain').innerHTML = ''

let select = document.querySelector('#paginacio-number')

function mostrar(num) {
  if (num == -1) {
    num = arrayGaleries.length
  }
  for (let i = 0; i < num; i++) {
    arrayGaleries[i].mostrar()
  }
  generarBotons()
} 
function mostrarPorPagina(numInicio, numFinal) {
  document.querySelector('#contain').innerHTML = ''
  for (let i = numInicio; i < numFinal; i++) {
    arrayGaleries[i].mostrar()
  } 
  generarBotons()
}

mostrar(select.value)

select.addEventListener('change', (e) => {
  document.querySelector('#contain').innerHTML = ''
  let cantidad = e.target.value
  mostrar(cantidad)
})

let paginacio = document.querySelector('.paginacio')

paginacio.innerHTML = ''

let numPaginas = Math.ceil(arrayGaleries.length / select.value) 
 
for (let i = 0; i < numPaginas; i++) { 
    let button = document.createElement('button')
    button.innerHTML = i + 1
    button.addEventListener('click', () => {
        mostrarPorPagina(i * select.value, i * select.value + parseInt(select.value))
    })
    paginacio.appendChild(button)
} 

function generarBotons() {
  document.querySelectorAll('#contain .item').forEach((div) => {
    let button = document.createElement('button')
    button.innerHTML = 'Pujar la imatge a la principal'
    button.addEventListener('click', () => {
      setImage(div.querySelector('img').src)
    })

    div.appendChild(button)
  })
  document.querySelectorAll('#contain .item').forEach((div) => {
    let finestra
    let pay = document.createElement('button')
    pay.innerHTML = 'Pagar'
    pay.addEventListener('click', () => {
      finestra = window.open(
        'https://www.paypal.com',
        '',
        'width=600,height=400',
      )
    })

    let tancar = document.createElement('button')
    tancar.innerHTML = 'Tancar'
    tancar.addEventListener('click', () => {
      finestra.close()
    })

    div.appendChild(pay)
    div.appendChild(tancar)
  })
}

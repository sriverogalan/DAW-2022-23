const sass = require('gulp-sass')(require('sass'));
const {src,dest} = require('gulp')  

function compiladorSASS(){
    return src('./node_modules/bootstrap/scss/**/*.scss')
        .pipe(sass().on('error', sass.logError))
        .pipe(dest('./dist/estils'));
} 

exports.default = compiladorSASS;
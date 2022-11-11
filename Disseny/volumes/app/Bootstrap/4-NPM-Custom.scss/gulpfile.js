const sass = require('gulp-sass')(require('sass'));
const {src,dest,parallel} = require('gulp')   

function compiladorSASS(){
    return src('./scss/**/*.scss')
        .pipe(sass().on('error', sass.logError))
        .pipe(dest('./css'));
} 

function copyjs(){
    return src('./node_modules/bootstrap/dist/js/dist/*.js')
        .pipe(dest('./js'));
}

exports.compila = compiladorSASS;
exports.copyjs = copyjs;
exports.default = parallel(compiladorSASS,copyjs);
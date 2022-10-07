const sass = require('gulp-sass')(require('sass'));
const {watch, src,dest,series,parallel} = require('gulp')
const cleanCSS = require('gulp-clean-css');
const concatCss = require('gulp-concat-css'); 
const validate = require('gulp-w3c-css');

//exemple com un hola mundo
function defaultTask(cb) {
    //put code for your default task here
    cb();
}

function compiladorSASS(){
    return src('./scss/**/*.scss')
        .pipe(sass().on('error', sass.logError))
        .pipe(dest('./dist/estils'));
}

function vigilarSASS(){
    watch('./scss/**/*.scss', {usePolling: true}, series('compila'));
}
    
function minimizarCSS() {
    return src('dist/*.css')
        .pipe(cleanCSS())
        .pipe(dest('./dist/estils'));
}

function concatCSS(){
    return src(['./dist/estils/b.css','./dist/estils/c.css', './dist/estils/a.css', './dist/estils/styles.css'])
        .pipe(concatCss('estils/bundle.css'))
        .pipe(dest('./dist/estils'))
}

function validateCSS(){
    return src('dist/**/*.css')
    .pipe(validate())
    .pipe(dest('validator'))
}

//serveix per exportar les tasques creades
exports.default = defaultTask;
exports.compila = compiladorSASS;
exports.vigila = vigilarSASS;
exports.minimizar = minimizarCSS;
exports.concatenar = concatCSS;
exports.validar = validateCSS;
exports.build = parallel(defaultTask,series(compiladorSASS,minimizarCSS,concatCSS,));
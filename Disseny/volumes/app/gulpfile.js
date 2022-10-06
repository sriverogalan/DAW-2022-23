const {watch, src, dest, series, task, parallel} = require('gulp');
const sass = require('gulp-sass')(require('sass'));
const minifyCSS = require('gulp-clean-css');
const concat = require('gulp-concat-css');
const validate = require('gulp-w3c-css');


async function compileSASS() {
    return src('./scss/**/*.scss')
        .pipe(sass.sync().on('error', sass.logError))
        .pipe(dest('./css'));
}

function defaultTask(cb) {
    // place code for your default task here
    cb();
}

function minimizeCSS() {
    return src('./css/*.css') 
        .pipe(dest('./css/mini'));
}

async function concatCSS() {
    return src(['./scss/**/b.css', './scss/**/c.css', "./scss/**/a.css"])
        .pipe(concat("./estils/bundle.css")) 
        .pipe(dest('./estils'));
}

async function validateCSS () {
    return src(['./css/**/*.css', './estils/**/*.css']) 
        .pipe(dest('./css/valid'));
}
 

task('watcher', async function () {
    watch('/app/scss/**/*.scss', {usePolling: true}, series('compile', 'minify'));
}); 
 
exports.defaultTask = defaultTask;
exports.compile = compileSASS;
exports.minify = minimizeCSS;
exports.concat = concatCSS;
exports.validate = validateCSS;
exports.build = parallel(defaultTask, series(compileSASS, minimizeCSS, concatCSS, validateCSS));
const gulp = require('gulp');
const sass = require('gulp-sass')(require('sass'));
const { watch } = require('gulp');

function buildStyles2() {
    return gulp.src('./sass/**/*.scss')
    .pipe(sass({outputStyle: 'expanded'}).on('error',sass.logError)) 
    .pipe(gulp.dest('./css'))
} 

function watcher() { 
   return watch('./sass/**/*.scss')
} 

exports.compila = buildStyles2 
exports.watcher = watcher
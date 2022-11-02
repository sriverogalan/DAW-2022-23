 const gulp = require('gulp');
const sass = require('gulp-sass')(require('sass')); 
const cssmin = require('gulp-cssmin');     
const imagemin = require('gulp-imagemin');
  

function comprimirCss () {
    return gulp.src('./css/*.css')
            .pipe(cssmin())
            .pipe(gulp.dest('./dist/css'));;
    };

function comprimirImg(){ 
   return gulp.src('./img/*')
        .pipe(imagemin())
        .pipe(gulp.dest('dist/images'))
}  
exports.comprimirCss  = comprimirCss
exports.comprimirImg = comprimirImg
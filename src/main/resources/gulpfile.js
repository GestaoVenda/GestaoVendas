/* CORE */
var gulp = require('gulp');
var sourcemaps = require('gulp-sourcemaps');
var rename = require("gulp-rename");

/* CSS */
var sass = require('gulp-sass');
var autoprefixer = require('gulp-autoprefixer');
var cssmin = require('gulp-cssmin');

/* IMAGE */
var imagemin = require('gulp-imagemin');



/* TASK - CSS */
/* BROWSERS - SUPPORT */
var browsers = [
    'Chrome >= 35',
    'Firefox >= 31',
    'Edge >= 12',
    'Explorer >= 9',
    'iOS >= 8',
    'Safari >= 8',
    'Android 2.3',
    'Android >= 4',
    'Opera >= 12'
];

gulp.task('style', function() {
    return gulp.src('static/css/scss/style.scss')
        .pipe(sourcemaps.init())
        .pipe(sass().on('error', sass.logError))
        .pipe(autoprefixer({
            browsers: browsers,
            cascade: false
        }))
        .pipe(sourcemaps.write('.'))
        .pipe(gulp.dest('static/css/'));
});

gulp.task('styleMin', ['style'], function() {
    return gulp.src('static/css/style.css')
        .pipe(rename({
            suffix: '.min'
        }))
        .pipe(sourcemaps.init())
        .pipe(cssmin())
        .pipe(sourcemaps.write('.'))
        .pipe(gulp.dest('static/css/'));
});

gulp.task('css:watch', function() {
    gulp.watch(
        [
            'static/css/scss/base/*.scss',
            'static/css/scss/layout/*.scss',
            'static/css/scss/module/*.scss',
            'static/css/scss/state/*.scss'
        ], ['styleMin']
    );
});



/* TASK - IMAGE */
gulp.task('imagemin', function() {
    return gulp.src(
            [
                'static/images/**/*.jpg',
                'static/images/**/*.png',
                'static/images/**/*.gif'
            ]
        )
        .pipe(imagemin())
        .pipe(gulp.dest('static/images'));
});
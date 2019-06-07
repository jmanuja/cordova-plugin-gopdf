/*
 * Author : Manuja Jayawardana
 * Github : https://github.com/jmanuja
 * File Name : GoPdf.js
 * 
 */
var exec = require('cordova/exec');

function GoPdf() {}

GoPdf.prototype.read = function (filePath, success, error) {
    
    exec(success || null , error || null, 'GoPdf', 'read', [filePath]);
};

module.exports = new GoPdf();
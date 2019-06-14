GOPDF 
=============
This plugin is developed to Read PDF files.

Following Libraries Used in the App

ItextG Android (https://github.com/itext/itextpdf)

Currently Supported Only for Android

Install
==================

```javascript
$ cordova plugin add https://github.com/jmanuja/cordova-plugin-gopdf.git
```

FUNCTIONS
==================

Read PDF as Text

This Function will be used to read PDF.
```javascript
read(fileURL , successCalleback , failureCallback);
```

fileURL - File Path

successCalleback - Method need to call if reading is successed. will receive response as json object.
    status - status message
    message - Pdf content

failureCallback - ethod need to call if reading is failed. will receive response as json object
    status - status message
    message - error message

To execute the functions cordova.plugins.GoPdf or window.GoPdf both Methods can be used.



EXAMPLE
==================
```javascript

    cordova.plugins.GoPdf.read(
        "file:///sdcard/Download/test.pdf", 
        success,
        error
    );

    var success = function(status) {
        alert('Message: ' + status);
    }

    var error = function(status) {
        alert('Error: ' + status);
    }

```

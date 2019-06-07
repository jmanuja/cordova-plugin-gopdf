GOPDF 
=============
This plugin is developed to Read PDF files.

Following Libraries Used in the App

ItextG Android (https://github.com/itext/itextpdf)

FUNCTIONS
==================

Read PDF as Text

This Function will be used to read PDF.
```javascript
read(fileURL , successCalleback , failureCallback);
```
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

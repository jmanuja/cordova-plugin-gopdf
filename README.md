GOPDF 
=============

=============
FUNCTIONS
=============

Read PDF as Text

This Function will be used to read PDF.

read(fileURL , successCalleback , failureCallback);

To execute the functions cordova.plugins.GoPdf or window.GoPdf both Methods can be used.

=============
EXAMPLE
=============
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
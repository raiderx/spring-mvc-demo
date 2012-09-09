function ajaxDialog(id, url, options, data) {
    var ajaxRequest;
    var dialogHolder = $("<div id='"+id+"'/>");

    function onDialogOpen() {

        //var form = dialogHolder.find(".dialogForm");
        //form.ajaxForm({ dataType: "json", success: onSubmit, data: options.extraFormData || {} });
        options.onOpen(dialogHolder);
    }

    function onDialogClose() {
        options.onClose();
        dialogHolder.dialog("destroy");
        dialogHolder.remove();
    }

    function openDialog(content) {
        dialogHolder.html(content);

        var form = dialogHolder.find(".dialogForm");

        options.title = options.title || form.attr("title") || "Dialog";
        options.width = options.width || parseInt(form.attr("width")) || 270;
        options.height = options.height || parseInt(form.attr("height")) || 230;

        form.removeAttr("title");
        form.removeAttr("width");
        form.removeAttr("height");

        dialogHolder.dialog(options);
        dialogHolder.dialog("open");
    }

    function errorHandler(xhr, textStatus, errorThrown) {
        alert("Error processing server request: " + xhr.status);
    }

    options = $.extend({
        type: "GET",
        autoOpen: false,
        modal: true,
        open: onDialogOpen,
        close: onDialogClose,
        onOpen: function(dialogHolder) {},
        onClose: function() {}
    }, options || {});

    if (ajaxRequest != null) {
        ajaxRequest.abort();
    }
    ajaxRequest = $.ajax({
        url: url,
        type: options.type,
        data: $.extend({ dialog: id }, data || {}),
        success: openDialog,
        error: errorHandler
    });
}

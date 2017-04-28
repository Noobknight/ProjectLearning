function onSubmitFormClick() {
    $("#formSubmit").submit(function(event) {
    	event.preventDefault();
        var fd = new FormData(this);
        // var file = $("input[name='category_image']")[0].files[0];
        // fd.append("image", file);
        $.ajax({
            url: "http://localhost:8070/api/product/save_category",
            type: "POST",
            processData: false,
            contentType: false,
            data: fd,
            succes: function(data) {
                console.log(data);
            },
            error: function(xhr, desc, err) {
                console.log(xhr);
            }
        });
    });
}
$(document).ready(function() {
    onSubmitFormClick();
});
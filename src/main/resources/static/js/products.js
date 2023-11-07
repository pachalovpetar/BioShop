$(function () {
    loadAllProducts();
});

function loadAllProducts() {
    $.ajax({
        type: 'GET',
        url: '/api/products',
        data: 'json',
        success: function (products) {
            $.each(products, function (i, product) {
                addProductDOM(product);
            })
        }
    })
}

function addProductDOM({id, name, imgUrl, price}) {
    $('#product-list')
        .append($('<output/>')
            .addClass('col col-xl-3 col-lg-4 col-md-6 col-sm-12 text-center pb-md-5 ml-md-0 mr-md-0')
            .append($('<div/>')
                .addClass('col col-md-12 text-center')
                .append(
                    $('<h4/>')
                        .addClass('text-center mt-5')
                        .append(
                            $('<span/>')
                                .addClass('badge badge-pill badge-secondary')
                                .text(name)
                        )
                )
                .append(
                    $('<h6/>')
                        .addClass('col col-md-12')
                )
            )
        );
}

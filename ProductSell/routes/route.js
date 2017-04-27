var database = require("../helpers/db.helper.js");
var dbHelper;

function RestRouter(router, connection) {
    var self = this;
    self.handleRouter(router, connection);
    self.dbHelper = new database(connection);
}

RestRouter.prototype.handleRouter = function (router, connection) {
    var self = this;
    router.get("/product/getAllProduct", function (req, res) {
        var limit = +req.query.limit || 10;
        var offset = +req.query.offset || 0;
        self.dbHelper.getAllProduct(function (data){
            res.json(data);
        }, limit, offset);
    });
    router.post("/product/save", function (req, res) {
        var body = req.body;
        if (body) {
            var product = {
                image: body.data.image,
                link: body.data.link
            };
            self.dbHelper.save(product, function (data) {
                res.json(data);
            });
        }
    });
    router.post(/product/save_category, function(req,res){
        
    });
    router.delete("/product/delete", function (req, res) {
        var id = req.query.product_id;
        if (id) {
            self.dbHelper.delete(id, function (data) {
                res.json(data);
            });
        }
    });
    router.put("/product/update", function (req, res) {
        var body = req.body;
        if (body) {
            var product = {
                product_id: body.data.product_id,
                image: body.data.image,
                link: body.data.link
            };
            self.dbHelper.update(product, function (data) {
                res.json(data);
            });
        }
    });
}

module.exports = RestRouter;
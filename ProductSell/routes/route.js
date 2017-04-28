var database = require("../helpers/db.helper.js");
var formidable = require("formidable");
var fs = require("fs");
var path = require("path");
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
        self.dbHelper.getAllProduct(function (data) {
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
    router.post("/product/save_category", function (req, res, next) {
        var form = new formidable.IncomingForm();
        form.parse(req, function (err, fields, files) {
            if (err) {
                console.log(err)
                return;
            }
            var projectPath = path.resolve(".");
            var file = path.join(projectPath, "public/images/") + files.category_image.name;
            var imageObj = files.category_image;
            var params = [fields.category_id, fields.category_name, fields.category_level, fields.category_description, fields.category_parent_id];
            fs.readFile(imageObj.path, function (err, data) {
                fs.writeFile(file, data, function (err) {
                    if (err) {
                        console.log(err);
                        return;
                    }
                    params.push("image/"+files.category_image.name);
                    self.dbHelper.insertCategory(params, function (data) {
                        res.json(data);
                    });
                });
            });
        });
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
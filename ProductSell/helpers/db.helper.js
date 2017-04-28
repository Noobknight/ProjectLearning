var randomstring = require("randomstring");
var mysql = require("mysql");
var constant = require("./constant");
var connection;

function DatabaseHelper(connection) {
    var self = this;
    this.connection = connection;
}

DatabaseHelper.prototype.save = function (product, callback) {
    // var isIdNotExist;
    // do {
    var id = randomstring.generate(7);
    var queryCheckId = "SELECT 1 FROM product WHERE product_id = ?";
    var params = [id];
    queryCheckId = mysql.format(queryCheckId, params);
    var connection = this.connection;
    this.connection.query(queryCheckId, function (err, res) {
        if (!err && res.length == 0) {
            // isIdNotExist = true;
            var query = "INSERT INTO product(`product_id`, `image`, `link`) VALUES(?,?,?)";
            var params = [id, product.image, product.link];
            query = mysql.format(query, params);
            connection.query(query, function (err, data) {
                if (err) {
                    var res = {
                        "status_code": constant.MSG_CODE.SUCCESS,
                        "message": constant.ErrorMsg.query,
                        "error_detail": err.message,
                        "content": []
                    }
                    return callback(res);
                }
                var result = {
                    "status_code": constant.MSG_CODE.SUCCESS,
                    "message": constant.ErrorMsg.message_ok,
                    "product_id": id
                };
                return callback(result);
            });
        } else {
            var res = {
                "status_code": constant.MSG_CODE.SUCCESS,
                "message": constant.ErrorMsg.msg_exist_id,
                "error_detail": err.message,
                "content": []
            }
            return callback(res);
        }
    });
    // } while (!isIdNotExist);
}

DatabaseHelper.prototype.insertCategory = function (params, callback) {
    var query = "INSERT INTO `category`(`category_id`, `name`, `level`, `description`, `parent_id`, `image`, `time_create`, `time_update`) VALUES (?,?,?,?,?,?,now(),now())";
    query = mysql.format(query, params);
    this.connection.query(query, function (err, row) {
        if (err) {
            var res = {
                "status_code": constant.MSG_CODE.SUCCESS,
                "message": constant.ErrorMsg.query,
                "error_detail": err.message,
                "content": []
            }
            return callback(res);
        }
        var result = {
            "status_code": constant.MSG_CODE.SUCCESS,
            "message": constant.ErrorMsg.message_ok,
            "category_id": params[0]
        };
        return callback(result);
    });
}


DatabaseHelper.prototype.delete = function (product_id, callback) {
    var query = "DELETE FROM product WHERE product_id = ?";
    var params = [product_id];
    query = mysql.format(query, params);
    this.connection.query(query, function (err, row) {
        if (err) {
            var res = {
                "status_code": constant.MSG_CODE.SUCCESS,
                "message": constant.ErrorMsg.query,
                "error_detail": err.message,
                "content": []
            }
            return callback(res);
        }
        var result = {
            "status_code": constant.MSG_CODE.SUCCESS,
            "message": constant.ErrorMsg.message_ok,
        };
        return callback(result);
    });
}

DatabaseHelper.prototype.update = function (product, callback) {
    var query = "UPDATE product SET image = ?, link = ? WHERE product_id = ?";
    var params = [product.image, product.link, product.product_id];
    query = mysql.format(query, params);
    this.connection.query(query, function (err, row) {
        if (err) {
            var res = {
                "status_code": constant.MSG_CODE.SUCCESS,
                "message": constant.ErrorMsg.query,
                "error_detail": err.message,
                "content": []
            }
            return callback(res);
        }
        var result = {
            "status_code": constant.MSG_CODE.SUCCESS,
            "message": constant.ErrorMsg.message_ok,
        };
        return callback(result);
    });
}


DatabaseHelper.prototype.getAllId = function (callback) {
    var query = "SELECT product_id FROM product";
    this.connection.query(query, function (err, res) {
        return callback(err, res);
    });
}

DatabaseHelper.prototype.getAllProduct = function (callback, limit, offset) {
    var query = "SELECT product_id, image, link FROM product LIMIT ? OFFSET ?";
    var params = [limit, offset];
    query = mysql.format(query, params);
    this.connection.query(query, function (err, data) {
        if (err) {
            var res = {
                "status_code": constant.MSG_CODE.SUCCESS,
                "message": constant.ErrorMsg.query,
                "content": []
            }
            return callback(res);
        }
        var count = data.length;
        var res = {
            "status_code": constant.MSG_CODE.SUCCESS,
            "message": constant.ErrorMsg.message_ok,
        }
        res.content = count > 0 ? data : constant.ErrorMsg.data;
        return callback(res);
    });
}

module.exports = DatabaseHelper;
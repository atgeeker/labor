/**
 * Created by zzy on 2017/9/5.
 */

/**
 * 成功
 * @param message
 * @param callback
 */
BootstrapDialog.success = function (message, callback) {
    return new BootstrapDialog({
        type: BootstrapDialog.TYPE_SUCCESS,
        message: message
    }).open();
};

/**
 * 危险
 * @param message
 * @param callback
 */
BootstrapDialog.danger = function (message, callback) {
    return new BootstrapDialog({
        type: BootstrapDialog.TYPE_DANGER,
        message: message
    }).open();
};

/**
 * 警告
 * @param message
 * @param callback
 */
BootstrapDialog.warning = function (message, callback) {
    return new BootstrapDialog({
        type: BootstrapDialog.TYPE_WARNING,
        message: message
    }).open();
};
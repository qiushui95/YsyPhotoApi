package son.ysy.photo.model.response

import son.ysy.photo.model.request.RequestPreCheck

data class ResponsePreCheck(val canUploadList: List<RequestPreCheck>, val containedList: List<RequestPreCheck>)
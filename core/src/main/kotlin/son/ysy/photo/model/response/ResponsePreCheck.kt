package son.ysy.photo.model.response

import son.ysy.photo.model.request.RequestUploadPreCheck

data class ResponsePreCheck(val canUploadList: List<RequestUploadPreCheck>, val containedList: List<RequestUploadPreCheck>)
package com.example.nocontextviewmodel.repository

import com.example.nocontextviewmodel.utils.Resource
import com.example.nocontextviewmodel.utils.ResponseHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class UserRepository(private val responseHandler: ResponseHandler) {

    suspend fun stimulateSocketTimeout() = flow {

        //stimulate a network call
        kotlinx.coroutines.delay(100)
        emit(
            //stimulate a failed network response
            if (false) {


                responseHandler
                    .handleSuccess("This should be api response")


            } else {
                Resource.Error(
                    responseHandler
                        .handleException<Int>(-1)
                )


            }
        )
    }.flowOn(Dispatchers.IO).catch { e ->
        e.printStackTrace()
        emit(

            Resource.Error(Resource.CustomMessages.NetworkError)

        )


    }

    suspend fun stimulateUnAuthorizedError() = flow {

        //stimulate a network call
        kotlinx.coroutines.delay(100)
        emit(
            //stimulate a failed network response
            if (false) {


                responseHandler
                    .handleSuccess("This should be api response")


            } else {
                Resource.Error(
                    responseHandler
                        .handleException<Int>(401)
                )


            }
        )
    }.flowOn(Dispatchers.IO).catch { e ->
        e.printStackTrace()
        emit(

            Resource.Error(Resource.CustomMessages.NetworkError)

        )


    }
    suspend fun stimulateSuccessfulNetworkCall()= flow {

        //stimulate a network call
        kotlinx.coroutines.delay(100)
        emit(
            //stimulate a failed network response
            if (true) {


                responseHandler
                    .handleSuccess("Sealed classes are awesome")


            } else {
                Resource.Error(
                    responseHandler
                        .handleException<Int>(401)
                )


            }
        )
    }.flowOn(Dispatchers.IO).catch { e ->
        e.printStackTrace()
        emit(

            Resource.Error(Resource.CustomMessages.NetworkError)

        )


    }
}
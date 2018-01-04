package cn.kevinz.swagger

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "return a test string"

    request {
        method 'GET'
        url '/user'
        body("")
    }
    response {
        status 200
        body("This is user list.")
    }
}





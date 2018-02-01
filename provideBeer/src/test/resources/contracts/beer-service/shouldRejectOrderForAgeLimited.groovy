package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    request {
        method 'POST'
        url '/beer'
        body("""
    {
      "id":"123456",
      "age":15,
      "name":"Greenberg",
      "amount":1,
      "desire":3
    }
    """)
        headers {
            contentType('application/json')
        }
    }
    response {
        status 200
        body([
                checkedStatus : "NOT_OK",
                "orderStatus" : false,
                "rejectReason": "Too young to get beer"
        ])
        headers {
            contentType('application/json')
        }
    }
}
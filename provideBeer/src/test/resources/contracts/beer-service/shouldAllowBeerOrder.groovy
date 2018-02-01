package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    request {
        method 'POST'
        url '/beer'
        body("""
    {
      "id":"123457",
      "age":21,
      "name":"Kevinz",
      "amount":1,
      "desire":2
    }
    """)
        headers {
            contentType('application/json')
        }
    }
    response {
        status 200
        body([
                checkedStatus: "OK",
                "orderStatus": true
        ])
        headers {
            contentType('application/json')
        }
    }
}
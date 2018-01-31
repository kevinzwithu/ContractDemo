package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    request {
        method 'POST'
        url '/beer'
        body("""
    {
      "Id":"123456",
      "Age":15,
      "Name":"Greenberg",
      "Amount":1,
      "Desire":3
    }
    """)
        headers {
            header('Content-Type', 'application/json')
        }
    }
    response {
        status 200
        body("""
  {
    "orderStatus": false,
    "rejectionReason": "Too young to get beer"
  }
  """)
        headers {
            header('Content-Type': 'application/json')
        }
    }
}
package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    request {
        method 'POST'
        url '/beer'
        body("""
    {
      "Id":"123457",
      "Age":21,
      "Name":"Kevinz",
      "Amount":1,
      "Desire":2
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
    "orderStatus": true
  }
  """)
        headers {
            header('Content-Type': 'application/json')
        }
    }
}
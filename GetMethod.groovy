/**
 * Calling the postman Api using GET method (groovy script)
 */

def postmanApi = new URL('https://postman-echo.com/get')
def url = postmanApi.openConnection()
url.requestMethod = 'GET'
assert url.responseCode == 200

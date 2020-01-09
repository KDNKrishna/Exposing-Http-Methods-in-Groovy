import groovy.json.JsonSlurper

/**
 * Making a post request by setting request method to post
 */

def postmanPostUrl = new URL('https://postman-echo.com/post')
def con = postmanPostUrl.openConnection()
con.requestMethod = 'POST'
assert con.responseCode == 200

/**
 * Passing the parameters to post using outputStream.withWriter
 */
def param = "xyz = This is new parameter"
def text
con.setDoOutput(true)
con.with {
    outputStream.withWriter { outputStreamWriter ->
        outputStreamWriter << param
    }
    text = content.text
}
assert con.responseCode == 200

/**
 * We received the data in the text format. Now we can parse (change the format) the data i.e text to Json using Json Slurper
*/

JsonSlurper jsonSlurper = new JsonSlurper()
assert jsonSlurper.parseText(text)?.json.xyz = "This is new parameter"



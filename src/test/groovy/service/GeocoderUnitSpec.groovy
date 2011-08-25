package service

import groovy.mock.interceptor.MockFor
import spock.lang.Specification
import beans.Stadium

class GeocoderUnitSpec extends Specification {
    String xml = '''
        <root><result><geometry>
            <location>
                <lat>37.422</lat>
                <lng>-122.083</lng>
            </location>
        </geometry></result></root>'''
    
    Stadium stadium = new Stadium(street:'1313 Mockingbird Lane',
        city:'New York',state:'NY')
    Geocoder geocoder = new Geocoder()
    
    def "check with mocked XmlSlurper"() {
        given:
        def root = new XmlSlurper().parseText(xml)
        def mock = new MockFor(XmlSlurper)
        mock.demand.parse { root }

        when:
        mock.use {
            geocoder.fillInLatLng(stadium)
        }

        then:
        Math.abs(stadium.latitude - 37.422) < 0.01
        Math.abs(stadium.longitude - -122.083) < 0.01        
    }
    
}

theme: /City
    
    state: Departure
        a: Назовите, пожалуйста, ваш город отправления.
        
        state: Get
            q: * $City *
            script:
                # log('\n parseTree.City \n' + toPrettyString($parseTree.City));
                $session.departureCity = $parseTree._City;
            a: Ваш город отправления: {{ $session.departureCity.name }}.
            go!: /City/Arrival
            
    state: Arrival
        a: Назовите, пожалуйста, ваш город прибытия. 
        
        state: Get
            q: * $City *
            script:
                $session.arrivalCity = $parseTree._City;
            a: Ваш город прибытия: {{ $session.arrivalCity.name }}.
            go!: /Weather/Current
    
    state: LocalNoMatch
        q: * || fromState = "/City"
        a: В нашей базе не предоставлено информации о таком городе. 
        go!: {{ $session.lastState }}
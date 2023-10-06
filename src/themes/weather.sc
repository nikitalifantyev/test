theme: /Weather

    state: Current
        script:
            $temp.currentWeather = getCurrentWeather($session.arrivalCity.lat, $session.arrivalCity.lon);
        if: $temp.currentWeather
            a: В городе {{ capitalize($nlp.inflect($session.arrivalCity.name, "loct")) }} сейчас {{ $temp.currentWeather.description }}, {{ Math.round($temp.currentWeather.temp) }}°C
        else:
            a: Не знаю.
        go!:/Satisfaction/SatisfiedClient
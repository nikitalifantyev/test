theme: /Luggage
    
    state: LuggageQuestion
        intent!: /luggage
        script:
            log(toPrettyString($parseTree));
            $session.tariff = $parseTree._tariff.name;
            if ($session.tariff === "Бизнес") {
                $session.luggage = 33
            } else {
                $session.luggage = 23
            }
        a: При классе обслуживания {{ $session.tariff }} норма провоза багажа: {{ $session.luggage }} кг.
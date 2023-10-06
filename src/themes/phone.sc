theme: /Phone
    
    state: AskPhone || modal = true
        a: Подскажите, пожалуйста, вам номер телефона в формате 79ХХХХХХХХХ.
        buttons:
            "Отмена"
          
        state: GetAPhone
            q: $phone
            go!: /Phone/IsItCorrect
            
        state: WrongPhone
            q: *
            a: Нам обязательно нужно уточнить ваш номер телефона для приобретения билетов. 
            go!: /Phone/AskPhone
    
    state: IsItCorrect
        script:
            $temp.phone = $parseTree._phone || $client.phone;
        a: Проверьте, пожалуйста, корректность вашего номера - {{ $temp.phone }}.
        script:
            $session.probablePhone = $temp.phone;
        buttons:
            "Номер верный."
            "В номере - ошибка."
        
        state: CorrectPhone
            q: (Номер верный.)
            script:
                $client.phone = $session.probablePhone
                delete $session.probablePhone
            a: Спасибо за предоставленную информацию!
            go!: /Discount/Inform
        
        state: NotCorrectPhone
            q: (В номере - ошибка.)
            go!: /Phone/AskPhone
            
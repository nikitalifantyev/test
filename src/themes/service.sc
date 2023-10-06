theme: /Service
    
    state: SuggestHelp
        a: Давайте я помогу вам купить билет на самолёт?
        buttons:
            "Да"
            "Нет"
        
        state: Yes
            q: * (да/дава*/хорошо/соглас*) *
            a: Буду рад вам помочь! 
            if: $client.phone
                go!: /Phone/IsItCorrect
            else:
                go!: /Phone/AskPhone 
        
        state: No
            q: * (не*/нет) *
            a: На данный момент я могу только продавать билеты на самолёт!
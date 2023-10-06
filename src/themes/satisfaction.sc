theme: /Satisfaction
    
    state: SatisfiedClient
        a: Мы очень хотим сделать нашего бота лучше! Скажите, пожалуйста, вам понравился наш сервис? 
        buttons:
            "Да" 
            "Нет"
        
        state: HappyClient
            q: да
            a: Спасибо за отзыв! Рады помочь! 
            script:
                $analytics.setSessionResult("Положительный отзыв")
            go!: /UpdatesInfo/AskToJoin
        
        state: UnhappyClient
            q: нет
            a: Мы не смогли вам помочь. Очень жаль.
            script:
                $analytics.setSessionResult("Отрицательный отзыв")

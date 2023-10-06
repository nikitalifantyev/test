theme: /UpdatesInfo
    
    state: AskToJoin
        a: Присоединяйтесь к нам и узнавайте первыми об обновлениях! 
        script:
            var branch = !testMode() ? $analytics.joinExperiment("UpdatesInfo") : "alreadyJoined";
            if (branch === "A") {
                $reactions.answer("Напишите свой email для получения информации об обновлениях!");
            } else if (branch === "B") {
                $response.replies = $response.replies || [];
                $response.replies.push({
                    type: "inlineButtons",
                    buttons: 
                        [
                        {"text": "Button 1" ,
                        "url": "https://news.harvard.edu/wp-content/uploads/2023/07/202307x_swift_1407_AP23198726852529-1600x900.jpg" }
                        ]
                    });
            } else {
               $reactions.answer("По всем вопросам вы можете обратиться по почте - hihihi@gmail.com!");
            }
            
            

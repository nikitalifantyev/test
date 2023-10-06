require:  localPatterns.sc
require:  themes/service.sc
require:  themes/phone.sc
require:  themes/discount.sc
require:  themes/city.sc
require:  themes/luggage.sc
require:  themes/weather.sc

require: slotfilling/slotFilling.sc
    module = sys.zb-common


require:  dictionaries/discount.yaml
    var = discountInfo
    
require: scripts/functions.js
    
require: city/cities-ru.csv
    module = sys.zb-common
    name = Cities
    var = $Cities

init:
    
    $global.$converters = {};
    
    $global.$converters.CityConverter = function CityConverter($parseTree) {
        return Cities[$parseTree.Cities[0].value].value;
    };
    
    bind("postProcess", function($context) {
        $context.session.lastState = $context.currentState;
        # log(toPrettyString($context.session.lastState));
    });
    
    # # bind("onAnyError", function($context) {
    # #     var answers = [
    # #         "Кажется, что-то не так!",
    # #         "Перепроверьте, пожалуйста!",
    # #         "Может, попробуете по-другому?"
    # #     ];
    #     var randomAnswer = answers[$reactions.random(answers.length)];
    #     $reactions.answer(randomAnswer);
    # });
    
theme: /

    state: Welcome
        q!: *start
        q!: $hi
        random:
            a: Здравствуйте!
            a: Приветствую!
        a: Меня зовут {{ capitalize($injector.botName) }}.
        script:
            $response.replies = $response.replies || []
            $response.replies.push({
                type: "image",
                imageUrl: "https://lurkmore.pro/images/thumb/6/6f/BOMJ-1.JPG/1280px-BOMJ-1.JPG",
                text: "Самолёт"
            });
        go!: /Service/SuggestHelp
    
    state: NoMatch || noContext = true
        event!: noMatch
        a: Простите, я не разобрался. Переформулируете свой запрос? 
        go!: {{ $session.lastState }}

    state: KnowledgeBase
        intentGroup!: /KnowledgeBase
        script:
            $faq.pushReplies();
        
patterns:
    
    $City = $entity<Cities> || converter = $converters.CityConverter
    
    $hi = (привет*/здравствуй*)
    $phone = $regexp<79\d{9}>

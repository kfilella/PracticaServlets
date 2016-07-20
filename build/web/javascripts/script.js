


    $(".reveal").on('click',function() {
        var $pwd = $("#txtPassword");
        if ($pwd.attr('type') === 'password') 
                    {
            $pwd.attr('type', 'text');
        } 
                    else 
                    {
            $pwd.attr('type', 'password');
        }
    });
    
    
    
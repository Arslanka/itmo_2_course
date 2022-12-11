%define next 0

%macro colon 2
        %ifid %2
             %2: dq next
             %define next %2
        %else
             %error "You have entered wrong id"
        %endif
        %ifstr %1
             db %1, 0
        %else
             %error "You have entered wrong key. It's  not a string"
        %endif
%endmacro

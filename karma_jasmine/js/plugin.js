(function ( $ ) {

    $.fn.validate = function(condition) {
      return this.each(function() {
            var elem = $( this );
            if(condition.test(elem.text())) {
              elem.css("background-color", "royalBlue")
            }
            else {
              elem.css("background-color", "red")
            }
      });
    };

    $.fn.field_validation = function(condition) {
      this.on('input keydown', function() {
        var elem = $( this );

            if(condition.test(elem.val())) {
              elem.css("border", "2px solid green")
            }
            else {
              elem.css("border", "2px solid red")
            }
            if(elem.val() == 0) {
              elem.css("border", "")
            }

      });
      return this;
    }

}( jQuery ));

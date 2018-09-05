document.addEventListener('DOMContentLoaded', function() {
    var elems = document.querySelectorAll('.collapsible');
    var instances = M.Collapsible.init(elems, options);
    var elems = document.querySelectorAll('.modal');
    var instances = M.Modal.init(elems, options);
    var elems = document.querySelectorAll('select');
    var instances = M.FormSelect.init(elems, options);
    var elems = document.querySelectorAll('.slider');
    var instances = M.Slider.init(elems, options);
    var elems = document.querySelectorAll('.sidenav');
    var instances = M.Sidenav.init(elems, options);
  });

(function($){
  $(function(){

    $('.collapsible').collapsible();
    $('.modal').modal();
    $('select').formSelect();
    $('.slider').slider();
    $('.sidenav').sidenav();

  }); // end of document ready
})(jQuery); // end of jQuery name space

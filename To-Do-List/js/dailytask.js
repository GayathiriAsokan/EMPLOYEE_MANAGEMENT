$(function() {
     $('#top').append('<span class="iconify" data-icon="mdi-dots-grid" data-inline="false"></span>')
     .append('<span class = "color To-do">To Do</span>')
     .append(' <button type="submit" class ="search-box"><i class="material-icons search-icon">search</i></button>')
     .append('<i class="fa fa-gear"></i><i class="fa fa-question"></i>')
     .append('<i class="fa fa-paper-plane-o"></i><span class="circle">G</span>');
     $('#left-icons').append('<span class="fa fa-bars"></span>')
     .append(' <ol><li class="list-task"><h> </h>My Day</li><li class="list-task"><i class="fa fa-star-o"></i>Important</li> <li class="list-task"> <i class="fa fa-calendar"></i>Planned</li><li class="list-task"><i class="fa fa-user-o"></i>Assign to you</li><li class="list-task"><i class="fa fa-home"></i>Tasks</li></ol>')
     .append('<span class="add-icon"><i class="fa fa-plus"></i>New list<i class="fa fa-folder"></i><i class="material-icons">add</i></span>');
    //  $('#left-icons').click(function(){
    //     $('').toggle();
    //   });
     $('#right-element').append('<p><span> Sort</span></p>');
    });
var template = {};

template.userSource = '<li class="media">' +
                      '<div class="media-body">' +
                      '<div class="media">' +
                      '<a class="pull-left" href="#">' + 
                      '<img class="media-object img-circle" style="max-height: 40px;"' +
                      'src="/image/avartar_in_circle.png" /></a> ' +
                      '<div class="media-body"><h5>{{userId}} | 사파이어</h5>' +
                      '<small class="text-muted"> 3시간째 게임중 </small></div>' +
                      '</div>' +
                      '</div>' +
                      '</li>';
    
template.userlistSource = '{{#each loginUsers}}'
    					+ '{{#> userPartial}}userPartial load fail{{/userPartial}}'
    					+ '{{/each}}';
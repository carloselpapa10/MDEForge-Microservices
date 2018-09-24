	var modal = $("#alert-modal")
	var modalTemplate;
	$.get(ctx + '/theme/scripts/plugins/forms/template/modal.html', function(template) {
		modalTemplate = template;
	});
	
	$("#deleteWorkspaceButton").click(function(){
		var button = $(this);
		var obj = {
				"id": button.data("id"),
				"name": button.data("name"),
				"type": "Workspace",
				"type2": "workspace"
		}
		var rendered = Mustache.render(modalTemplate, obj);
		modal.html(rendered);
		modal.modal("show")
	})
	
	$(document).on('click', '#deleteWorkspace', function(event){
		$("#deleteWorkspaceButton").addClass("disabled")
		$("#deleteWorkspaceForm").submit()
	})
	
	$(document).on('click', '.removeArtifact', function(event){
		var idArtifact = $(this).data('id');
		var idProject = $('#projectId').attr('data-id');
		$.ajax({
			url : ctx + "/private/project/" + idProject + "/remove/" + idArtifact,
			success : function(data) {
				//debugger;
				//$('#artifact-' + idArtifact).remove();
			},
			error : function error(data) {
				//debugger;
				if(data.responseText == "ok"){
					$('#artifact-' + idArtifact).remove();
					$.gritter.add({
						title: 'The artifact has been removed from the project',
						text: ""
					});
				}else{
					$.gritter.add({
						title: "Ops! Something went wrong!",
						text: "Try Later."
					});
				}
				
			}
			
		});
	});

	$(document).on('click','#addEcore', function(event){
		var ecoreMetamodel = new Object();
		var button = $(this);
		var select =  $('#ecoreSelect');
		ecoreMetamodel.id = select.data("id");
		ecoreMetamodel.name = select.data("name");
		//when input is null
		if(ecoreMetamodel.id === "undefined" || select.val().length == 0){
			//select.before('<div id="addProjectAlert" class="alert alert-error"><span>No Metamodel Selected</span></div>')
			select.addClass("input-error").attr("placeholder", "No Metamodel Selected");
			return false;
		}
		//when input has been edited
		if(ecoreMetamodel.name === "undefined" || select.val() != ecoreMetamodel.name){
			//select.before('<div id="addProjectAlert" class="alert alert-error"><span>No Metamodel Selected</span></div>')
			select.val("").addClass("input-error").attr("placeholder", "Invalid Input");
			return false;
		}
		button.addClass("disabled-button");
		ecoreMetamodel.ecoreMetamdel = true;
		var idProject = $('#projectId').attr('data-id');
		console.log("1 _ " + idProject);
		ecoreMetamodel.projectId = idProject;
		
		$.ajax({
			
			url : ctx + "/private/project/" + idProject + "/add/" + ecoreMetamodel.id,
			success : function(data) {
				console.log('jjj' + ctx)
				var result = $('#ecoreMMTable');
				$.get(ctx + '/theme/scripts/plugins/forms/template/artifactRowInWorkspace.html',
						function(template) {
							var rendered = Mustache.render(template, ecoreMetamodel);
							result.append(rendered);
				});
				//$("#ecoreSelect option[value='" + ecoreMetamodel.id + "']").remove();
				$('#ecoreToAdd').hide();
				select.val("");
				$("#showEcoreList").removeClass("rotate-item");
				button.removeClass("disabled-button")
				$.gritter.add({
					title: 'The Ecore Metamodel has been added to project',
					text: ""
				});
			},
			error : function error(data) {
				console.log('error');
				button.removeClass("disabled-button")
				select.after('<div id="addEcoreAlert" class="alert alert-error"><button type="button" class="close" data-dismiss="alert">x</button><span>Ops! Something went wrong! Try Again.</span></div>')
			}
		});
	});
		
	$(document).on('click','#addATL', function(event){
		var ATLTransormation = new Object();
		var button = $(this);
		var select = $('#ATLSelect')
		ATLTransormation.id = select.data("id");
		ATLTransormation.name = select.data("name")
		//when input is null
		if(ATLTransormation.id === "undefined" || select.val().length == 0){
			//select.before('<div id="addProjectAlert" class="alert alert-error"><span>No Metamodel Selected</span></div>')
			select.addClass("input-error").attr("placeholder", "No Transformation Selected");
			return false;
		}
		//when input has been edited
		if(ATLTransormation.name === "undefined" || select.val() != ATLTransormation.name){
			//select.before('<div id="addProjectAlert" class="alert alert-error"><span>No Metamodel Selected</span></div>')
			select.val("").addClass("input-error").attr("placeholder", "Invalid Input");
			return false;
		}
		button.addClass("disabled-button");
		console.log("2 _ " + idProject);
		var idProject = $('#projectId').attr('data-id');
		ATLTransormation.projectId = idProject;
		ATLTransormation.ATLTransformation = true;
		$.ajax({
			url : ctx + "/private/project/" + idProject + "/add/" + ATLTransormation.id,
			success : function(data) {
				var result = $('#atlTable');
				$.get(ctx + '/theme/scripts/plugins/forms/template/artifactRowInWorkspace.html',
						function(template) {
							var rendered = Mustache.render(template, ATLTransormation);
							result.append(rendered);
					});
				//$("#ATLSelect option[value='" + ATLTransormation.id + "']").remove();
				$('#ATLToAdd').hide();
				select.empty();
				$("#showATLList").removeClass("rotate-item");
				button.removeClass("disabled-button")
				$.gritter.add({
					title: 'The ATL Transformation has been added to project',
					text: ""
				});
			},
			error : function error(data) {
				console.log('error');
				button.removeClass("disabled-button")
				select.after('<div id="addEcoreAlert" class="alert alert-error"><button type="button" class="close" data-dismiss="alert">x</button><span>Ops! Something went wrong! Try Again.</span></div>')
			}
			
		});
	});


	$(document).on('click','#addModel', function(event){
		var model = new Object();
		var button = $(this);
		var select = $('#modelSelect');
		model.id = select.data("id");
		model.name = select.data("name");
		//when input is null
		if(model.id === "undefined" || select.val().length == 0){
			//select.before('<div id="addProjectAlert" class="alert alert-error"><span>No Metamodel Selected</span></div>')
			select.addClass("input-error").attr("placeholder", "No Metamodel Selected");
			return false;
		}
		//when input has been edited
		if(model.name === "undefined" || select.val() != model.name){
			//select.before('<div id="addProjectAlert" class="alert alert-error"><span>No Metamodel Selected</span></div>')
			select.val("").addClass("input-error").attr("placeholder", "Invalid Input");
			return false;
		}
		button.addClass("disabled-button");
		model.model = true;
		var idProject = $('#projectId').attr('data-id');
		console.log("3 _ " + idProject);
		model.projectId = idProject;
		$.ajax({
			url : ctx + "/private/project/" + idProject + "/add/" + model.id,
			success : function(data) {
				var result = $('#modelTable');
				$.get(ctx + '/theme/scripts/plugins/forms/template/artifactRowInWorkspace.html',
						function(template) {
							var rendered = Mustache.render(template, model);
							result.append(rendered);
					});
				//$("#modelSelect option[value='" + model.id + "']").remove();
				$('#modelToAdd').hide();
				select.empty();
				$("#showModelList").removeClass("rotate-item");
				button.removeClass("disabled-button")
				$.gritter.add({
					title: 'The Model has been added to project',
					text: ""
				});
				
			},
			error : function error(data) {
				console.log('error');
				button.removeClass("disabled-button")
				select.after('<div id="addEcoreAlert" class="alert alert-error"><button type="button" class="close" data-dismiss="alert">x</button><span>Ops! Something went wrong! Try Again.</span></div>')
			}
		});
	});
	
	// SHOW ARTIFACT BY TYPE
	$('#showModelList').click(showModelList);
	function showModelList(event){
		if (!($(this).hasClass("rotate-item"))) {
			$(this).addClass("rotate-item");
			var ids =[];
			$('#modelTable > tbody  > tr').each(function() {
				ids.push(this.id);
			});
			$('#modelToAdd').show();
					//$(document).on('click','#showModelList', showModelList);
		}
		else {
			$('#modelToAdd').hide();
			$(this).removeClass("rotate-item");
		}
	}
	
	$('#showATLList').click(showATLList);
	function showATLList(event){
		if (!($(this).hasClass("rotate-item"))) {
			$(this).addClass("rotate-item");
			var ids =[];
			$('#atlTable > tbody  > tr').each(function() {
				ids.push(this.id);
			});
			$('#ATLToAdd').show();
					//$(document).on('click','#showATLList', showATLList); perchè altro listener?
		}
		else {
			$('#ATLToAdd').hide();
			$(this).removeClass("rotate-item");
		}
	}
	$('#showEcoreList').click(showEcoreList);
	
	function showEcoreList(event){
		if (!($(this).hasClass("rotate-item"))){
			$(this).addClass("rotate-item");
			var ids =[];
			$('#ecoreMMTable > tbody  > tr').each(function() {
				ids.push(this.id);
			});
			//inizialize plugin for this ajax select
			$('#ecoreToAdd').show();
					//$(document).on('click','#showEcoreList', showEcoreList); perchè altro listener?
					//$('#showEcoreList').one(showEcoreList);
		}
		else {
			$('#ecoreToAdd').hide();
			$(this).removeClass("rotate-item");
		}
	}
	
	//SHARE OR UNSHARE PROJECT
	
	$(document).on('click','#addUser', function(event){
		$("#addUserAlert").remove();
		var button = $(this);
		var select = $('#userSelect');
		var idUser = select.val();
		if(idUser == null || idUser == "" || idUser.length == 0){
			select.before('<div id="addProjectAlert" class="alert alert-error"><button type="button" class="close" data-dismiss="alert">x</button><span>No User Selected</span></div>')
			return false;
		}
		button.addClass("disabled-button");
		var nameModel = $("#userSelect option:selected").text();
		var idProject = $("#projectId").attr('data-id');
		$.ajax({
			url : ctx + "/private/project/" + idProject + "/addUser/" + idUser,
			success : function(data) {
				var result = $('#users');
				$.get(ctx + '/theme/scripts/plugins/forms/template/userBox.html',
						function(template) {
							var rendered = Mustache.render(template, data);
							result.append(rendered);
				});
				//$("#userSelect option[value='" + idUser + "']").remove();
				$('#userList').hide();
				$("#showUserList").removeClass("rotate-item");
				button.removeClass("disabled-button");
				$.gritter.add({
					title: 'Project has been shared with ' + data.firstname,
					text: ""
				});
				shared_users += 1;
				$('#sharedNumber').html('<span  class="text-black strong">'+ shared_users +'</span> people shares this project');
				
			},
			error : function error(data) {
				select.before('<div id="addUserAlert" class="alert alert-error"><button type="button" class="close" data-dismiss="alert">x</button><span>Ops! Something went wrong. Try Again.</span></div>')
				button.removeClass("disabled-button");
				console.log('error')
			}
		});
	});
	
	$(document).on('click','.removeSharedUser', function(event){
		//debugger;
		var idProject = $('#projectId').attr('data-id');
		var idUser = $(this).data('id');
		$.ajax({
			url : ctx + "/private/project/" + idProject + "/removeUser/" + idUser,
			success : function(data) {
				$('.sharedUser[data-id="'+ idUser +'"]').remove();
                $('.userLi[data-id="'+ idUser+'"]').remove();
                $('.UserLi[data-id="'+ idUser+'"]').remove();

                shared_users -= 1;
                /*

                if (shared_users > 0) {
                    $('#sharedNumber').html('<span  class="text-black strong">' + shared_users + '</span> people shares this project');
                }
                else{
                        $('#sharedNumber').html('No one shares this project.');
                }*/
				
			},
			error : function error(data) {
				console.log('error');
				$('.sharedUser[data-id="'+ idUser +'"]').remove();
			}
		});
	});
	
	// WORKSPACE MANAGEMENT
	$(document).on('click','#addProject', function(event){
		var button = $(this);
		$("#addProjectAlert").remove();
		var select = $('#projectSelect');
		var idProject = select.val();
		if(idProject == "" || idProject == null){
			if(select.children().length > 0)
				select.before('<div id="addProjectAlert" class="alert alert-error"><button type="button" class="close" data-dismiss="alert">x</button><span>No Project Selected</span></div>')
			else{
				select.before('<div id="addProjectAlert" class="alert alert-error"><span>No Project Available</span></div>')
				button.addClass("disabled-button").removeClass("btn-success");
			}
			return false;
		}else{
			button.addClass("disabled-button");
		}
		var idWorkspace = $("#workspaceId").data('id');
		
		$.ajax({
			url : ctx + "/private/workspace/" + idWorkspace + "/add/" + idProject,
			success : function(data) {
				data.ctx = ctx;
				var result = $('#projectList');
				$.get(ctx + '/theme/scripts/plugins/forms/template/projectInArtifact.html',
						function(template) {
							var rendered = Mustache.render(template, data);
							result.append(rendered);
						});
				$("#projectSelect option[value='" + idProject + "']").remove();
				$('#projectsToAdd').hide();
				$('#showProjectList').html('Add Project <i class="icon-angle-down"></i>').addClass("btn-primary").removeClass("btn-large");
				button.removeClass("disabled-button")
				$.gritter.add({
					title: 'Project has been added to Workspace',
					text: ""
				});
			},
			error : function error(data) {
				console.log('error');
				button.removeClass("disabled-button")
				select.before('<div id="addProjectAlert" class="alert alert-error"><button type="button" class="close" data-dismiss="alert">x</button><span>Ops! Something went wrong. Try Again.</span></div>')
			}
			
		});
	});
	
	$(document).on('click', '#removeProject', function(event){
		event.stopPropagation();

		$('#removeProjectAlert').remove();
		var button = $(this);
		button.addClass("disabled-button");
		var idProject = $(this).data('id');
		var nameProject = $(this).data('name');
		var idWorkspace = $("#workspaceId").data('id');
		$.ajax({
			url : ctx + "/private/workspace/" + idWorkspace + "/remove/" + idProject,
			success : function(data) {
				var item = $('#item_' + idProject);
				item.remove();
				$('#projectSelect').append($('<option></option>').attr('value',idProject).text(nameProject));
				$('#workspaceDetailsDiv').hide();
				button.removeClass("disabled-button");
				$.gritter.add({
					title: nameProject + ' has been removed from Workspace',
					text: ""
				});
			},
			error : function (err) {
				if(err.responseText == "ok"){
					var item = $('#item_' + idProject);
					item.remove();
					$('#projectSelect').append($('<option></option>').attr('value',idProject).text(nameProject));
					$('#workspaceDetailsDiv').hide();
					$.gritter.add({
						title: nameProject + ' has been removed from Workspace',
						text: ""
					});
				}else{
					console.log(err)
					$('#details').append('<div id="removeProjectAlert" class="alert alert-error"><button type="button" class="close" data-dismiss="alert">x</button><span>Ops! Something went wrong. Try Again.</span></div>')
					
				}
				button.removeClass("disabled-button");
				
			}
			
		});
	});
	
	$(document).on('click', '#deleteProjectButton', function(event){
		var button = $(this);
		var obj = {
				"id": button.data("id"),
				"name": button.data("name"),
				"type": "Project",
				"type2": "project"
		}
		var rendered = Mustache.render(modalTemplate, obj);
		modal.html(rendered);
		modal.modal("show")
	});
	
	
	/* DELETE PROJECT */
	$(document).on('click', '#deleteProject', function(event){
		event.stopPropagation();

		$('#removeProjectAlert').remove();
		var button = $(this);
		button.addClass("disabled-button");
		var idProject = $(this).data('id');
		var nameProject = $(this).data('name');
		var idWorkspace = $("#workspaceId").data('id');
		$.ajax({
			url : "/private/project/delete/"+idProject,
			type: "GET",
			success : function(data) {
				var item = $('#item_' + idProject);
				item.remove();
				$('#workspaceDetailsDiv').hide();
				button.removeClass("disabled-button");
				$.gritter.add({
					title: nameProject + ' has been deleted',
					text: ""
				});
			},
			error : function (err) {
				if(err.responseText == "ok"){
					var item = $('#item_' + idProject);
					item.remove();
					$('#workspaceDetailsDiv').hide();
					$.gritter.add({
						title: nameProject + ' has been deleted',
						text: ""
					});
				}else{
					console.log(err)
					$('#details').append('<div id="removeProjectAlert" class="alert alert-error pull-right"><button type="button" class="close" data-dismiss="alert">x</button><span>Ops! Something went wrong. Try Again.</span></div>')
					
				}
				button.removeClass("disabled-button");
				
			}
			
		});
	});
	/* END DELETE PROJECT */
	
	$('#showProjectList').click(function(event){
		if ($('#projectsToAdd').css('display') == 'none') {
			$('#projectsToAdd').show();
			$('#showProjectList').html('Close <i class="icon-angle-up"></i>').addClass("btn-large").removeClass("btn-primary");
		}
		else {
			$('#projectsToAdd').hide();
			$('#showProjectList').html('Add Project <i class="icon-angle-down"></i>').addClass("btn-primary").removeClass("btn-large");
		}
	});
	
	// JSFiddle
	/*This function start the Jsfiddle configuration*/
	function jsfiddleView(tagid, id){
		var workspaceProj = $("#workspaceDetailsDiv");
		var workspaceJsfiddle = $("#workspaceDetailsJsfiddleDiv");
		
		workspaceProj.hide();
		workspaceJsfiddle.show();
		$("#jsfiddleBody").html("");
		
		$.ajax({
			url : ctx + "/private/jsfiddle/" + id,
			success : function(data) {
				$('#jsfiddleName').text(data.name);
				$('#jsfiddleOwnerEmail').text(data.owner.email);
				$('#jsfiddleOwnerName').text(data.owner.firstname + ' ' + data.owner.lastname);
				$('#jsfiddleOwnerUsername').text(data.owner.username);
				
				html = "";
				contentViewLength = data.contentViewList.length;
				$.each(data.contentViewList, function (i, contentView){
					index = i+1;
					
					if(i%2==0){
						html += '<div class="row-fluid">';						
					}
					
					if(contentView.type == "editor"){
						
						var editorListHmtl="<select style='width: 100%' margin-bottom: '15px'>";
						
						for(x = 0; x < contentView.contentType.editorTypeList.length; x++){
							selected="";
							if(contentView.contentType.editorTypeList[x] == contentView.contentType.type){
								selected="selected";
							}
							editorListHmtl += "<option value="+x+" "+selected+"> "+contentView.contentType.editorTypeList[x]+"</option>"
						}
						
						editorListHmtl += "</select>";
						
						if(contentView.contentViewArtifactId != null){
							html += '<div class="span6 contentView" style="min-height: 218px;"><div class="span12"><div class="span9"><h4>'+index+'. '+contentView.name+'</h4></div><div class="span3"><button type="button" class="btn btn-default pull-right" onclick="clearEditor()">Clean</button></div></div><div>'+editorListHmtl+'</div><div id="'+contentView.type+'_artifactList_'+contentView.contentViewArtifactId+'"></div></div>';							
						}else if(contentView.artifatcId != null){
							html += '<div class="span6 contentView"><h4>'+index+'. '+contentView.name+'</h4><div id="">ArtifactId: '+contentView.artifatcId+'</div></div>';
						}else{
							html += 'The Editor ContentView was not configured the correct way...';
						}						
							
					}else if(contentView.type == "artifactList"){
						
						html += "<div class='span6 contentView'><div class='span12'><div class='span9'><h4>"+index+". "+contentView.name+"</h4></div><div class='span3'><button type='button' class='btn btn-default pull-right' onclick='clearArtifactList("+contentView.type+"_"+contentView.id+")'>Clean</button></div></div><table id='"+contentView.type+"_"+contentView.id+"' class='display dataTableArtifacts' width='100%'></table></div>";	
						console.log("artifactList");
					}else if(contentView.type == "serviceList"){
						
						buttons="";
						for(var x=0; x<contentView.services.length ; x++){
							buttons += "<button type='button' data-id="+x+" class='btn btn-primary' id="+contentView.id+"_"+contentView.services[x].name+" > "+contentView.services[x].name+" </button> ";
						}						
						
						html += '<div class="span6 contentView"><h4>'+index+'. '+contentView.name+' </h4><div id="'+contentView.type+'_'+contentView.id+'">'+buttons+'</div></div>';
						console.log("serviceList");
					}else if(contentView.type == "table"){
						
						html += '<div class="span6 contentView"><h4>'+index+'. '+contentView.name+' </h4><div id="'+contentView.type+'_'+contentView.id+'"></div></div>';	
						console.log("table");
					}else if(contentView.type == "emptyDiv"){
						
						html += "<div class='span6 contentView'><div class='span12'><div class='span9'><h4>"+index+". "+contentView.name+" </h4></div><div class='span3'><button type='button' class='btn btn-default pull-right' onclick=clearEmptyDiv("+contentView.type+"_"+contentView.id+") >Clean</button></div></div><div class='emptyList' data-id='"+contentView.type+"_"+contentView.id+"' id='"+contentView.type+"_"+contentView.id+"'></div></div>";	
						console.log("emptyDiv");
					}
					
					if(i%2!=0){
						html += '</div>';
					}
					
					if(i == contentViewLength-1){
						$("#jsfiddleBody").append(html);
					}
					
				});
				
				$.each(data.contentViewList, function (i, contentView){
					if(contentView.type == "artifactList"){
						var content;
						switch(contentView.artifactType){
							case "EcoreMetamodel":
								content = data.contentViewList[i].contentType.ecoreMetamodelList;
								break;
							case "Model":
								content = data.contentViewList[i].contentType.modelList;
								break;
							case "ATLTransformation":
								content = data.contentViewList[i].contentType.atlTransformationList;
								break;
							default:
								break;
						}					
						
						dataTableArtifactList(contentView.type+'_'+contentView.id , content);
					}
					
					if(contentView.type == "serviceList"){
						var xa = "aa";
						
						for(var x = 0; x < contentView.services.length; x++){
							
							$( "#"+contentView.id+"_"+contentView.services[x].name ).click(function() {
								
								var flag = true;
								
								for(var y = 0; y < contentView.services[$(this).data('id')].artifacts.length; y++){
									
									if(! $("#artifactList_"+contentView.services[$(this).data('id')].artifacts[y]).DataTable().rows( '.selected' ).any()){
										flag = false;									
									}									
								}
								
								if(flag){
									
									if(contentView.services[$(this).data('id')].method=="GET"){
										
										$.ajax({
											url : ctx + contentView.services[$(this).data('id')].url + $("#artifactList_"+contentView.services[$(this).data('id')].artifacts[0]).DataTable().rows('.selected').data()[0].id,
											success : function(data) {
												ShowInEmptyList(data);
											},
											error : function(error){
												alert(error);
											}
										});
										
									}else{
										
										var models = new Array();
										var model = {id:'',_class:''};
										
										for(var y=1; y < contentView.services[$(this).data('id')].artifacts.length; y++ ){
											model.id= $("#artifactList_"+contentView.services[$(this).data('id')].artifacts[y]).DataTable().rows('.selected').data()[0].id;
											model._class = $("#artifactList_"+contentView.services[$(this).data('id')].artifacts[y]).DataTable().rows('.selected').data()[0]._class;
											models[y-1]=model;
										}										
										
										$.ajax({
											url : ctx + contentView.services[$(this).data('id')].url + $("#artifactList_"+contentView.services[$(this).data('id')].artifacts[0]).DataTable().rows('.selected').data()[0].id,
											data : JSON.stringify(models),
											type: contentView.services[$(this).data('id')].method,
										    processData: false,
											contentType : "application/json",
											success : function(data) {
												if(data[0] != undefined && data[0].name != undefined){
													ShowInEmptyList(data[0].name);
												}else{
													ShowInEmptyList(data);
												}
												
											},
											error : function(error){
												alert(error);
											}
										});
										
									}
									
									
								}else{
									alert(contentView.services[$(this).data('id')].msg);
								}

							});
						}
						
					}
				});
				
			},
			error : function error(error) {
				alert(error);
			}
		});
	}
		
	function ShowInEmptyList(data){
		/*fix it*/
		$(".emptyList ").each(function(i, element) {		
		    $("#"+element.attributes['id'].value).html(data);
		});
	}
	
	function clearArtifactList(idTableArtifactList){
		$('#'+idTableArtifactList.attributes["id"].value+" tbody tr").removeClass('selected');
	}
	
	function clearEmptyDiv(idEmptyDiv){
		$("#"+idEmptyDiv.attributes["id"].value).html("");
	}
	
	function clearEditor(){
		
	}
	
	function dataTableArtifactList(id,dataSet){
		
		if ( $.fn.dataTable.isDataTable( '#'+id ) ) {
		    table = $('#'+id).DataTable();
		}
		else {
			var table =$('#'+id).DataTable({
				data: dataSet,
				"responsive": true,
				"info": false,
				"pageLength": 5,
				"pagingType": "simple",
				"bLengthChange": false,
				"language": {
				    "processing":'<img class="spinner" src="${pageContext.request.contextPath}/resources/theme/images/spin.gif"></span>'
				},
		        columns: [
		            { 
		            	title: "Name",
		            	data:'name',
		            	render: function ( data, type, full, meta ) {  
		            		return data.length > 10 ?
		            	        '<span title="'+data+'">'+data.substr( 0, 20 )+'...</span>' :
		            	        data;
		            	    }
		            },
		            { 
		            	title: "Type",
		            	data:'_class'
		            },
		            { 
		            	title: "Author",
		            	data:'author.username'
		            },
		            {
		            	title: "id",
		            	data: 'id',
		            	"visible": false
		            }
		        ]
			});	
			
			$('#'+id+' tbody').on( 'click', 'tr', function () {
		        
				var data = table.row( this ).data();
		        $("#editor_"+table.tables().nodes().to$().attr('id')).html(data.name);	        
				
				if ( $(this).hasClass('selected') ) {
		            $(this).removeClass('selected');
		        }
		        else {
		            table.$('tr.selected').removeClass('selected');
		            $(this).addClass('selected');
		        }
				
		    } );
			
		}
		
	}
	
	// WORKSPACE LOADING
	$('.widget-employees').each(function(){
		if (typeof $.fn.select2 != 'undefined') 
			$(this).find('select').select2();
		
		equalHeight($(this).find('.row-merge > [class*="span"]'));
		
		$(this).on('click', '.listWrapper li:not(.active)', function()
		{
			var p = $(this).parents('.widget-employees:first');
			p.find('.listWrapper li').removeClass('active');
			$(this).addClass('active');
			var tagid = $(this).attr('id');
			var id = $(this).data('id');
			if(tagid.substring(0,12) == "itemJsfiddle"){
				jsfiddleView(tagid, id);
				return null;
			}
			$.ajax({
				url : ctx + "/private/project/" + id,
				success : function(data) {
					$('#projectId').attr('data-id',data.id);

					var workspace = $("#workspaceDetailsDiv");
					var workspaceJsfiddle = $("#workspaceDetailsJsfiddleDiv");
					workspace.show();
					workspaceJsfiddle.hide();
					$('#users').empty();
					$('#ATLToAdd').hide();
					$('#modelToAdd').hide();
					$('#ecoreToAdd').hide();
					$('#userList').hide();
					//buttons
					$('.button-toggle').removeClass("rotate-item");
					//GLOBAL VARIABLE
					shared_users = data.userlist.length;
					if (data.userlist.length > 0)

						$('#sharedNumber').html('<span  class="text-black strong">'+ shared_users +'</span> people shares this project');
					else{
						$('#sharedNumber').html('No one shares this project.');
					}

					if (data.artifactlist.length > 1)
						$('#artifactsNumber').text(data.artifactlist.length + " artifacts");
					else
						$('#artifactsNumber').text(data.artifactlist.length + " artifact");
					$('#userDiv').show();

					var guard = data.owner.email == loggedUserEmail;
					if (guard)
						$('#showUserList').show();
					else
						$('#showUserList').hide();
					$.each(data.userlist, function(i, user) {
						if(data.owner.id != user.id) {
							var  stringHead = '<li data-id="' + user.id + '" class="sharedUser UserLi"><span class="glyphicons activity-icon user"><i></i></span><span class="title">' +
					           		user.username + ' <br><strong>' + user.firstname + ' ' + user.lastname + '</strong></span>';
							var stringDelete = '';
							if (guard)
								stringDelete = '<span class="pull-right icon-remove removeSharedUser text-error" data-id="' + user.id + '" ></span>';
							var stringTail = '</span></li>';
							$('#users').append(stringHead + stringDelete + stringTail);
						}
					});
					$('#ecoreMMTable').empty();
					$('#atlTable').empty();
					$('#modelTable').empty();
					var resultEcore = $('#ecoreMMTable');
					var resultAtl = $('#atlTable');
					var resultModels = $('#modelTable');
					$.each(data.artifactlist, function(i, artifact) {
						if(artifact._class == "org.mdeforge.business.model.EcoreMetamodel") {
							artifact.ecoreMetamdel = true;
							var idProject = $('#projectId').attr('data-id');
							artifact.ctx = ctx;
							artifact.projectId = idProject;
							$.get(ctx + '/theme/scripts/plugins/forms/template/artifactRowInWorkspace.html',
									function(template) {
										var rendered = Mustache.render(template, artifact);
										resultEcore.append(rendered);
								});
						}
						if(artifact._class == "org.mdeforge.business.model.ATLTransformation") {
							artifact.ATLTransformation = true;
							var idProject = $('#projectId').attr('data-id');
							artifact.projectId = idProject;
							artifact.ctx = ctx;
							$.get(ctx + '/theme/scripts/plugins/forms/template/artifactRowInWorkspace.html',
									function(template) {
										var rendered = Mustache.render(template, artifact);
										resultAtl.append(rendered);
								});
						}
						if(artifact._class == "org.mdeforge.business.model.Model") {
							artifact.model = true;
							var idProject = $('#projectId').attr('data-id');
							artifact.projectId = idProject;
							$.get(ctx + '/theme/scripts/plugins/forms/template/artifactRowInWorkspace.html',
									function(template) {
										var rendered = Mustache.render(template, artifact);
										resultModels.append(rendered);
								});
						}
					});
					if(data.open === true){
						$('#visibility').html('<span class="btn btn-success"><i class="icon-cloud"></i> Public</span>')
					}else{
						$('#visibility').html('<span class="btn btn-danger"><i class="icon-lock"></i> Private</span>')
					}
					var removeButton = $('#removeProject').data("id", data.id).data("name", data.name)

                    if(loggedUserEmail == data.owner.email){
						removeButton.next().html('<span id="deleteProjectButton" class="btn btn-danger" data-id="'+ data.id +'" data-name="'+ data.name +'" style="margin-top: 20px"><i class="icon-remove"></i> Delete Project</span>')
					}
					
					$('#projectName').text(data.name);
					$('#projectDesc').text(data.description);
					$('#ownerEmail').text(data.owner.email);
					$('#ownerName').text(data.owner.firstname + ' ' + data.owner.lastname);
					$('#ownerUsername').text(data.owner.username);
				},
				error : function error(data) {
					$('#projectName').text(data);
				}
			})
		});
	});
	
	$('#showProjectAdd').click(function(event){
		if ($('#createProject').css('display') == 'none') {
			$('#createProject').show();
			$('#showProjectAdd').html('Close <i class="icon-angle-up"></i>').addClass("btn-large").removeClass("btn-primary");
		}
		else {
			$('#createProject').hide();
			$('#showProjectAdd').html('Create New Project <i class="icon-angle-down"></i>').addClass("btn-primary").removeClass("btn-large");
		}
	});
	
	//UTILITY
	function equalHeight(boxes)	{
		boxes.height('auto');
		var maxHeight = Math.max.apply( Math, boxes.map(function(){ return $(this).height(); }).get());
		boxes.height(maxHeight);
	}
	
	$(document).on('click', '#addNewProject', function(event){
		event.stopPropagation();
		var button = $(this);
		$("#addProjectAlert").remove();
		var pname = $('#createProjectName');
		var desc_obj = $('#createProjectDesc');
		var description = desc_obj.val();
		var open_obj = $('#createProjectOpen');
		var open = open_obj.val();
		pname.removeClass("input-error");
		var idProject = pname.val();
		if(idProject == "" || idProject.length == 0){
			pname.before('<div id="addProjectAlert" class="alert alert-error"><button type="button" class="close" data-dismiss="alert">x</button><span>Please, Insert the Project name</span></div>').addClass("input-error")
			return false;
		}else{
			button.addClass("disabled-button");
		}
		//var nameProject = $(this).data('name');
		var idWorkspace = $("#workspaceId").data('id');
		$.ajax({
			url : ctx + "/private/workspace/" + idWorkspace + "/addNewProjectToWorkspace/",
			type: "POST",
			data: {
				open: open,
				description: description,
				name: idProject
			},
			success : function(data) {
				var result = $('#projectList');
				$.get(ctx + '/theme/scripts/plugins/forms/template/projectInArtifact.html', function(template) {
					var rendered = Mustache.render(template, data);
					result.append(rendered);
				});
				//$('#createNewProject').text('createProjectName');
				$('#createProject').hide();
				$('#showProjectAdd').html('Create New Project <i class="icon-angle-down"></i>').addClass("btn-primary").removeClass("btn-large");
				button.removeClass("disabled-button")
				$.gritter.add({
					title: 'Project has been created and added to Workspace',
					text: ""
				});
				pname.val("");
				desc_obj.val("");
				open_obj.val('true');
			},
			error : function error(data) {
				console.log('error');
				pname.before('<div id="newProjectAlert" class="alert alert-error"><button type="button" class="close" data-dismiss="alert">x</button><span>Ops! Something went wrong. Try Again</span></div>').addClass("input-error")
				button.removeClass("disabled-button")
			}
		});
	});
	
	$(document).on('click','#showUserList',function(event){
		var button = $(this);
		button.addClass("disabled-button");
		if (!($(this).hasClass("rotate-item"))) {
			$.ajax({
				url : ctx + "/private/user/list",
				success : function(data) {
					var select = $('#userSelect');
					button.addClass("rotate-item").removeClass("disabled-button");

					$('#userSelect').empty();
					$.each(data, function(i, model){
						if(loggedUserEmail != model.email)
							select.append('<option value='+model.id+' >'+model.username+'</option>');
					});
					$('#userList').show();
				},
				error : function error(data) {
					console.log('error');
				}
			});
		}
		else {
			$('#userList').hide();
			$(this).removeClass('rotate-item disabled-button');
		}
	});

/* SELECT AJAX INITIALIZATION*/
var delay = null;
$(document).ready(function(){
	initSelects($('.my-select'));
})


function initSelects(select){
	//select is a text input
	select.each(function(e){
		$(this).after('<div class="my-select-control"><div class="my-select-dropdown">' + 
						'<div id="select-content" class="my-select-content">' + 
		                '</div></div></div>');
		var next = $(this).next();
		$(this).data("target", next)
		$(this).data("content", next.find("#select-content"))
	});
}

/* MY SELECT EVENTS */
$("body").on("mousedown", ".my-select-item", function(e){
	e.preventDefault();
	var input = $(this).closest(".my-select-control").prev();
	
	input
		.data("id", $(this).data("id")).data("name", $(this)
		.data("name"))
		.val($(this).data("name"))
		.blur()
})

$('.my-select')
.focus(function(e){
	$(this).removeClass("input-error").attr("placeholder", "Search " + $(this).data("type") + "s");
	$(this).data("target").addClass("dropdown-open");
})
.blur(function(e){
	$(this).data("target").removeClass("dropdown-open")
})
.keyup(function(e){
	if (delay !== null) {
        clearTimeout(delay);
    }
	var type = $(this).data("type");
	var project = $(this).data("project");
	var that = $(this);
	delay = setTimeout(
			function(){
				if(that.val().length > 0)
					getArtifactsForProject(type, project, that)
	}, 500)
})

function getArtifactsForProject(typeArtifact, project, input){
	//project is to ignore artifacts for that project
	//if project is null all artifacts will be retrived
	//typeArtifact can be "EcoreMetamodel", "ATLTransformation", "Model"
	//input is the html element
	var select = input.data("content");
	var query = input.val();
	select.html('<div class="my-select-item-info">' +
            '<span class="by loagind-select text-primary">Loading...</span>' +
    '</div>');
	$.ajax({
	    type: "POST",
	    url: ctx + '/public/searchArtifact',
	    data: {
        	search_string: query,
        	id_project: project,
        	type: typeArtifact,
        	limit: 50
        },
	    dataType:'json',
	    success: function(data) {
	    	console.log(data)
	    	var options = '';  
			if(data.length > 0){
				data.forEach(function(item, index, array){
			    	   options += '<div class="my-select-item" data-id="'+ item.id +'" data-name="'+ item.name +'">' +
				                '<h5 class="text-black strong">' + escape(item.name) + '</h5>' +
				                    '<span class="by">' + escape(item.author.username) + '</span>' +
				            '</div>';              
			       }); 
			}
			else{
				options = '<div class="my-select-item-info"><span class="by text-primary">No result found.</span></div>';
			}
			select.html(options);
	    },
	    error: function(res){
	    	console.log(res);
	    	select.html('<div class="my-select-item-info"><span class="by text-error">Ops. Something went wrong. Try Again</span></div>');
	    }
	});
}
// /private/project/delete method:DELETE data:{ idProject: 
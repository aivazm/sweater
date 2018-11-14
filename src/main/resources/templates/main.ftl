<#import "parts/common.ftl" as c>

<@c.page>
<div class="form-row">
    <div class="form-group col-md-6">
        <form method="get" action="/main" class="form-inline">
            <input type="text" class="form-control" name="filter" value="${filter?if_exists}" placeholder="Search by tag...">
            <button class="btn btn-primary ml-3" type="submit">Search</button>
        </form>
    </div>
</div>
<a class="btn btn-primary" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
    Add new message
</a>
<div class="collapse" id="collapseExample">
    <div class="form-group mt-3">
        <form method="post" enctype="multipart/form-data">
            <div class="form-group">
                <input class="form-control" type="text" name="text" placeholder="Enter your message" />
            </div>
            <div class="form-group">
                <input class="form-control" type="text" name="tag" placeholder="Tag">
            </div>
            <div class="form-group">
                <div class="custom-file">
                    <input class="form-control" type="file" name="file" id="customFile">
                    <label class="custom-file-label" for="customFile">Choose file</label>
                </div>
            </div>
            <div>
                <input type="hidden" name="_csrf" value="${_csrf.token}"/>
            </div>
            <div class="form-group">
                <button class="btn btn-primary" type="submit">Добавить</button>
            </div>
        </form>
    </div>
</div>
<div class="card-columns">
    <#list messages as message>
<div class="card my-3">
    <#if message.filename??>
        <img class="card-img-top" src="/img/${message.filename}">
    </#if>
    <div class="m-2"
        <span>${message.text}</span>
        <i>${message.tag}</i>
    </div>
    <div class="card-footer text-muted">
        ${message.authorName}
    </div>
</div>
    <#else>
No message
    </#list>
</div>

</@c.page>
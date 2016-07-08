<%@page import="java.io.Console"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<t:page>        
    <jsp:body>
        <div class="bottom-container">
            <div id="tabs" class="tabs-leage">
                <ul class="tab-header">
                    <li class="tab-active"><a href="#tabs-1">NFL</a></li>
                    <li class="tab-normal"><a href="#tabs-2">PGA</a></li>
                    <li class="tab-normal"><a href="#tabs-3">Wimbledon</a></li>
                    <li class="tab-normal"><a href="#tabs-4">US Open</a></li>
                </ul>
                <div id="tabs-1">
                    <div class="nfl-tab-title">
                        <img  src="${pageContext.request.contextPath}/img/nfl/logo/NFL.png">
                        <p>NFL Scorecard</p>
                    </div>
                    <div class="ul-wrapper">
                        <ul class="tabs-team">
                            <li class="border-right"><a class="none-pl" href="#">Summary</a></li>
                            <li class="border-right"><a href="#">Box Score</a></li>
                            <li class="border-right"><a class="active" href="#">Team Stats</a></li>
                            <li class="border-right"><a href="#">NFL Standings</a></li>
                            <li><a href="#">Conversation</a></li>
                        </ul>
                        <div style="clear:both"></div>
                    </div>
                    <div class="table-team">
                        <div class="col-md-6 col-sm-12 col-lg-6">
                            <table class="table-north">
                                <tr class="table-header">
                                    <td colspan="2">
                                        <p class="mtb-5"><img class="left-logo"  src="${pageContext.request.contextPath}/img/nfl/logo/nfc.png">
                                            <span>NFC NORTH</span></p>
                                    </td>
                                </tr>
                                <tbody>
                                    <tr class="table-body odds">
                                        <td>
                                            <div class="img-wrapper">
                                                <img  src="${pageContext.request.contextPath}/img/nfl/logo/logo-team.png">
                                            </div>
                                        </td>
                                        <td class="small-text td-divider pd-8 text-center border-right"><span style="padding-right: 8px;">Chicago Bears</span><i class="mdi mdi-checkbox-blank-circle"></i><a class="border-right" href="#">Stats</a><i></i><a class="border-right" href="#">Schedule</a><i></i><a href="#">Roster</a></td>
                                    </tr>
                                    <tr class="table-body evens">
                                        <td>
                                            <div class="img-wrapper">
                                                <img  src="${pageContext.request.contextPath}/img/nfl/logo/logo-team.png">
                                            </div>
                                        </td>
                                        <td class="small-text td-divider pd-8 text-center border-right"><span style="padding-right: 8px;">Chicago Bears</span><i class="mdi mdi-checkbox-blank-circle"></i><a class="border-right" href="#">Stats</a><i></i><a class="border-right" href="#">Schedule</a><i></i><a href="#">Roster</a></td>
                                    </tr>
                                    <tr class="table-body odds">
                                        <td>
                                            <div class="img-wrapper">
                                                <img  src="${pageContext.request.contextPath}/img/nfl/logo/logo-team.png">
                                            </div>
                                        </td>
                                        <td class="small-text td-divider pd-8 text-center border-right"><span style="padding-right: 8px;">Chicago Bears</span><i class="mdi mdi-checkbox-blank-circle"></i><a class="border-right" href="#">Stats</a><i></i><a class="border-right" href="#">Schedule</a><i></i><a href="#">Roster</a></td>
                                    </tr>
                                    <tr class="table-body evens">
                                        <td>
                                            <div class="img-wrapper">
                                                <img  src="${pageContext.request.contextPath}/img/nfl/logo/logo-team.png">
                                            </div>
                                        </td>
                                        <td class="small-text td-divider pd-8 text-center border-right"><span style="padding-right: 8px;">Chicago Bears</span><i class="mdi mdi-checkbox-blank-circle"></i><a class="border-right" href="#">Stats</a><i></i><a class="border-right" href="#">Schedule</a><i></i><a href="#">Roster</a></td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>  
                        <div class="col-md-6 col-sm-12 col-lg-6">
                            <table class="table-north">
                                <tr class="table-header">
                                    <td colspan="2">
                                        <p class="mtb-5"><span>AFC NORTH</span>
                                            <img class="right-logo"  src="${pageContext.request.contextPath}/img/nfl/logo/afc.png"></p>
                                    </td>
                                </tr>
                                <tbody>
                                    <tr class="table-body odds">
                                        <td>
                                            <div class="img-wrapper">
                                                <img  src="${pageContext.request.contextPath}/img/nfl/logo/logo-team.png">
                                            </div>
                                        </td>
                                        <td class="small-text td-divider pd-8 text-center"><span style="padding-right: 8px;">Chicago Bears</span><i class="mdi mdi-checkbox-blank-circle"></i><a href="#">Stats</a><i></i><a href="#">Schedule</a><i></i><a href="#">Roster</a></td>
                                    </tr>
                                    <tr class="table-body evens">
                                        <td>
                                            <div class="img-wrapper">
                                                <img  src="${pageContext.request.contextPath}/img/nfl/logo/logo-team.png">
                                            </div>
                                        </td>
                                        <td class="small-text td-divider pd-8 text-center"><span style="padding-right: 8px;">Chicago Bears</span><i class="mdi mdi-checkbox-blank-circle"></i><a href="#">Stats</a><i></i><a href="#">Schedule</a><i></i><a href="#">Roster</a></td>
                                    </tr>
                                    <tr class="table-body odds">
                                        <td>
                                            <div class="img-wrapper">
                                                <img  src="${pageContext.request.contextPath}/img/nfl/logo/logo-team.png">
                                            </div>
                                        </td>
                                        <td class="small-text td-divider pd-8 text-center"><span style="padding-right: 8px;">Chicago Bears</span><i class="mdi mdi-checkbox-blank-circle"></i><a href="#">Stats</a><i></i><a href="#">Schedule</a><i></i><a href="#">Roster</a></td>
                                    </tr>
                                    <tr class="table-body evens">
                                        <td>
                                            <div class="img-wrapper">
                                                <img  src="${pageContext.request.contextPath}/img/nfl/logo/logo-team.png">
                                            </div>
                                        </td>
                                        <td class="small-text td-divider pd-8 text-center"><span style="padding-right: 8px;">Chicago Bears</span><i class="mdi mdi-checkbox-blank-circle"></i><a href="#">Stats</a><i></i><a href="#">Schedule</a><i></i><a href="#">Roster</a></td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                        <div class="col-md-6 col-sm-12 col-lg-6">
                            <table class="table-others">
                                <tr class="table-header">
                                    <td colspan="2">
                                        <p class="mtb-5"><i class="mdi mdi-checkbox-blank-circle i-nfc"></i><span>NFC SOUTH</span></p>
                                    </td>
                                </tr>
                                <tbody>
                                    <tr class="table-body odds">
                                        <td>
                                            <div class="img-wrapper">
                                                <img  src="${pageContext.request.contextPath}/img/nfl/logo/logo-team.png">
                                            </div>
                                        </td>
                                        <td class="small-text td-divider pd-8 text-center border-right"><span style="padding-right: 8px;">Chicago Bears</span><i class="mdi mdi-checkbox-blank-circle"></i><a class="border-right" href="#">Stats</a><i></i><a class="border-right" href="#">Schedule</a><i></i><a href="#">Roster</a></td>
                                    </tr>
                                    <tr class="table-body evens">
                                        <td>
                                            <div class="img-wrapper">
                                                <img  src="${pageContext.request.contextPath}/img/nfl/logo/logo-team.png">
                                            </div>
                                        </td>
                                        <td class="small-text td-divider pd-8 text-center border-right"><span style="padding-right: 8px;">Chicago Bears</span><i class="mdi mdi-checkbox-blank-circle"></i><a class="border-right" href="#">Stats</a><i></i><a class="border-right" href="#">Schedule</a><i></i><a href="#">Roster</a></td>
                                    </tr>
                                    <tr class="table-body odds">
                                        <td>
                                            <div class="img-wrapper">
                                                <img  src="${pageContext.request.contextPath}/img/nfl/logo/logo-team.png">
                                            </div>
                                        </td>
                                        <td class="small-text td-divider pd-8 text-center border-right"><span style="padding-right: 8px;">Chicago Bears</span><i class="mdi mdi-checkbox-blank-circle"></i><a class="border-right" href="#">Stats</a><i></i><a class="border-right" href="#">Schedule</a><i></i><a href="#">Roster</a></td>
                                    </tr>
                                    <tr class="table-body evens">
                                        <td>
                                            <div class="img-wrapper">
                                                <img  src="${pageContext.request.contextPath}/img/nfl/logo/logo-team.png">
                                            </div>
                                        </td>
                                        <td class="small-text td-divider pd-8 text-center border-right"><span style="padding-right: 8px;">Chicago Bears</span><i class="mdi mdi-checkbox-blank-circle"></i><a class="border-right" href="#">Stats</a><i></i><a class="border-right" href="#">Schedule</a><i></i><a href="#">Roster</a></td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                        <div class="col-md-6 col-sm-12 col-lg-6">
                            <table class="table-others">
                                <tr class="table-header">
                                    <td colspan="2">
                                        <p class="mtb-5"><i class="mdi mdi-checkbox-blank-circle i-afc"></i><span>AFC SOUTH</span></p>
                                    </td>
                                </tr>
                                <tbody>
                                    <tr class="table-body odds">
                                        <td>
                                            <div class="img-wrapper">
                                                <img  src="${pageContext.request.contextPath}/img/nfl/logo/logo-team.png">
                                            </div>
                                        </td>
                                        <td class="small-text td-divider pd-8 text-center"><span style="padding-right: 8px;">Chicago Bears</span><i class="mdi mdi-checkbox-blank-circle"></i><a href="#">Stats</a><i></i><a href="#">Schedule</a><i></i><a href="#">Roster</a></td>
                                    </tr>
                                    <tr class="table-body evens">
                                        <td>
                                            <div class="img-wrapper">
                                                <img  src="${pageContext.request.contextPath}/img/nfl/logo/logo-team.png">
                                            </div>
                                        </td>
                                        <td class="small-text td-divider pd-8 text-center"><span style="padding-right: 8px;">Chicago Bears</span><i class="mdi mdi-checkbox-blank-circle"></i><a href="#">Stats</a><i></i><a href="#">Schedule</a><i></i><a href="#">Roster</a></td>
                                    </tr>
                                    <tr class="table-body odds">
                                        <td>
                                            <div class="img-wrapper">
                                                <img  src="${pageContext.request.contextPath}/img/nfl/logo/logo-team.png">
                                            </div>
                                        </td>
                                        <td class="small-text td-divider pd-8 text-center"><span style="padding-right: 8px;">Chicago Bears</span><i class="mdi mdi-checkbox-blank-circle"></i><a href="#">Stats</a><i></i><a href="#">Schedule</a><i></i><a href="#">Roster</a></td>
                                    </tr>
                                    <tr class="table-body evens">
                                        <td>
                                            <div class="img-wrapper">
                                                <img  src="${pageContext.request.contextPath}/img/nfl/logo/logo-team.png">
                                            </div>
                                        </td>
                                        <td class="small-text td-divider pd-8 text-center"><span style="padding-right: 8px;">Chicago Bears</span><i class="mdi mdi-checkbox-blank-circle"></i><a href="#">Stats</a><i></i><a href="#">Schedule</a><i></i><a href="#">Roster</a></td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                        <div class="col-md-6 col-sm-12 col-lg-6">
                            <table class="table-others">
                                <tr class="table-header">
                                    <td colspan="2">
                                        <p class="mtb-5"><i class="mdi mdi-checkbox-blank-circle i-nfc"></i><span>NFC EAST</span></p>
                                    </td>
                                </tr>
                                <tbody>
                                    <tr class="table-body odds">
                                        <td>
                                            <div class="img-wrapper">
                                                <img  src="${pageContext.request.contextPath}/img/nfl/logo/logo-team.png">
                                            </div>
                                        </td>
                                        <td class="small-text td-divider pd-8 text-center border-right"><span style="padding-right: 8px;">Chicago Bears</span><i class="mdi mdi-checkbox-blank-circle"></i><a class="border-right" href="#">Stats</a><i></i><a class="border-right" href="#">Schedule</a><i></i><a href="#">Roster</a></td>
                                    </tr>
                                    <tr class="table-body evens">
                                        <td>
                                            <div class="img-wrapper">
                                                <img  src="${pageContext.request.contextPath}/img/nfl/logo/logo-team.png">
                                            </div>
                                        </td>
                                        <td class="small-text td-divider pd-8 text-center border-right"><span style="padding-right: 8px;">Chicago Bears</span><i class="mdi mdi-checkbox-blank-circle"></i><a class="border-right" href="#">Stats</a><i></i><a class="border-right" href="#">Schedule</a><i></i><a href="#">Roster</a></td>
                                    </tr>
                                    <tr class="table-body odds">
                                        <td>
                                            <div class="img-wrapper">
                                                <img  src="${pageContext.request.contextPath}/img/nfl/logo/logo-team.png">
                                            </div>
                                        </td>
                                        <td class="small-text td-divider pd-8 text-center border-right"><span style="padding-right: 8px;">Chicago Bears</span><i class="mdi mdi-checkbox-blank-circle"></i><a class="border-right" href="#">Stats</a><i></i><a class="border-right" href="#">Schedule</a><i></i><a href="#">Roster</a></td>
                                    </tr>
                                    <tr class="table-body evens">
                                        <td>
                                            <div class="img-wrapper">
                                                <img  src="${pageContext.request.contextPath}/img/nfl/logo/logo-team.png">
                                            </div>
                                        </td>
                                        <td class="small-text td-divider pd-8 text-center border-right"><span style="padding-right: 8px;">Chicago Bears</span><i class="mdi mdi-checkbox-blank-circle"></i><a class="border-right" href="#">Stats</a><i></i><a class="border-right" href="#">Schedule</a><i></i><a href="#">Roster</a></td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>  
                        <div class="col-md-6 col-sm-12 col-lg-6">
                            <table class="table-others">
                                <tr class="table-header">
                                    <td colspan="2">
                                        <p class="mtb-5"><i class="mdi mdi-checkbox-blank-circle i-afc"></i><span>AFC EAST</span></p>
                                    </td>
                                </tr>
                                <tbody>
                                    <tr class="table-body odds">
                                        <td>
                                            <div class="img-wrapper">
                                                <img  src="${pageContext.request.contextPath}/img/nfl/logo/logo-team.png">
                                            </div>
                                        </td>
                                        <td class="small-text td-divider pd-8 text-center border-right"><span style="padding-right: 8px;">Chicago Bears</span><i class="mdi mdi-checkbox-blank-circle"></i><a class="border-right" href="#">Stats</a><i></i><a class="border-right" href="#">Schedule</a><i></i><a href="#">Roster</a></td>
                                    </tr>
                                    <tr class="table-body evens">
                                        <td>
                                            <div class="img-wrapper">
                                                <img  src="${pageContext.request.contextPath}/img/nfl/logo/logo-team.png">
                                            </div>
                                        </td>
                                        <td class="small-text td-divider pd-8 text-center border-right"><span style="padding-right: 8px;">Chicago Bears</span><i class="mdi mdi-checkbox-blank-circle"></i><a class="border-right" href="#">Stats</a><i></i><a class="border-right" href="#">Schedule</a><i></i><a href="#">Roster</a></td>
                                    </tr>
                                    <tr class="table-body odds">
                                        <td>
                                            <div class="img-wrapper">
                                                <img  src="${pageContext.request.contextPath}/img/nfl/logo/logo-team.png">
                                            </div>
                                        </td>
                                        <td class="small-text td-divider pd-8 text-center border-right"><span style="padding-right: 8px;">Chicago Bears</span><i class="mdi mdi-checkbox-blank-circle"></i><a class="border-right" href="#">Stats</a><i></i><a class="border-right" href="#">Schedule</a><i></i><a href="#">Roster</a></td>
                                    </tr>
                                    <tr class="table-body evens">
                                        <td>
                                            <div class="img-wrapper">
                                                <img  src="${pageContext.request.contextPath}/img/nfl/logo/logo-team.png">
                                            </div>
                                        </td>
                                        <td class="small-text td-divider pd-8 text-center border-right"><span style="padding-right: 8px;">Chicago Bears</span><i class="mdi mdi-checkbox-blank-circle"></i><a class="border-right" href="#">Stats</a><i></i><a class="border-right" href="#">Schedule</a><i></i><a href="#">Roster</a></td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                        <div class="col-md-6 col-sm-12 col-lg-6">
                            <table class="table-others">
                                <tr class="table-header">
                                    <td colspan="2">
                                        <p class="mtb-5"><i class="mdi mdi-checkbox-blank-circle i-nfc"></i><span>NFC WEST</span></p>
                                    </td>
                                </tr>
                                <tbody>
                                    <tr class="table-body odds">
                                        <td>
                                            <div class="img-wrapper">
                                                <img  src="${pageContext.request.contextPath}/img/nfl/logo/logo-team.png">
                                            </div>
                                        </td>
                                        <td class="small-text td-divider pd-8 text-center border-right"><span style="padding-right: 8px;">Chicago Bears</span><i class="mdi mdi-checkbox-blank-circle"></i><a class="border-right" href="#">Stats</a><i></i><a class="border-right" href="#">Schedule</a><i></i><a href="#">Roster</a></td>
                                    </tr>
                                    <tr class="table-body evens">
                                        <td>
                                            <div class="img-wrapper">
                                                <img  src="${pageContext.request.contextPath}/img/nfl/logo/logo-team.png">
                                            </div>
                                        </td>
                                        <td class="small-text td-divider pd-8 text-center border-right"><span style="padding-right: 8px;">Chicago Bears</span><i class="mdi mdi-checkbox-blank-circle"></i><a class="border-right" href="#">Stats</a><i></i><a class="border-right" href="#">Schedule</a><i></i><a href="#">Roster</a></td>
                                    </tr>
                                    <tr class="table-body odds">
                                        <td>
                                            <div class="img-wrapper">
                                                <img  src="${pageContext.request.contextPath}/img/nfl/logo/logo-team.png">
                                            </div>
                                        </td>
                                        <td class="small-text td-divider pd-8 text-center border-right"><span style="padding-right: 8px;">Chicago Bears</span><i class="mdi mdi-checkbox-blank-circle"></i><a class="border-right" href="#">Stats</a><i></i><a class="border-right" href="#">Schedule</a><i></i><a href="#">Roster</a></td>
                                    </tr>
                                    <tr class="table-body evens">
                                        <td>
                                            <div class="img-wrapper">
                                                <img  src="${pageContext.request.contextPath}/img/nfl/logo/logo-team.png">
                                            </div>
                                        </td>
                                        <td class="small-text td-divider pd-8 text-center border-right"><span style="padding-right: 8px;">Chicago Bears</span><i class="mdi mdi-checkbox-blank-circle"></i><a class="border-right" href="#">Stats</a><i></i><a class="border-right" href="#">Schedule</a><i></i><a href="#">Roster</a></td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                        <div class="col-md-6 col-sm-12 col-lg-6">
                            <table class="table-others">
                                <tr class="table-header">
                                    <td colspan="2">
                                        <p class="mtb-5"><i class="mdi mdi-checkbox-blank-circle i-afc"></i><span>AFC WEST</span></p>
                                    </td>
                                </tr>
                                <tbody>
                                    <tr class="table-body odds">
                                        <td>
                                            <div class="img-wrapper">
                                                <img  src="${pageContext.request.contextPath}/img/nfl/logo/logo-team.png">
                                            </div>
                                        </td>
                                        <td class="small-text td-divider pd-8 text-center border-right"><span style="padding-right: 8px;">Chicago Bears</span><i class="mdi mdi-checkbox-blank-circle"></i><a class="border-right" href="#">Stats</a><i></i><a class="border-right" href="#">Schedule</a><i></i><a href="#">Roster</a></td>
                                    </tr>
                                    <tr class="table-body evens">
                                        <td>
                                            <div class="img-wrapper">
                                                <img  src="${pageContext.request.contextPath}/img/nfl/logo/logo-team.png">
                                            </div>
                                        </td>
                                        <td class="small-text td-divider pd-8 text-center border-right"><span style="padding-right: 8px;">Chicago Bears</span><i class="mdi mdi-checkbox-blank-circle"></i><a class="border-right" href="#">Stats</a><i></i><a class="border-right" href="#">Schedule</a><i></i><a href="#">Roster</a></td>
                                    </tr>
                                    <tr class="table-body odds">
                                        <td>
                                            <div class="img-wrapper">
                                                <img  src="${pageContext.request.contextPath}/img/nfl/logo/logo-team.png">
                                            </div>
                                        </td>
                                        <td class="small-text td-divider pd-8 text-center border-right"><span style="padding-right: 8px;">Chicago Bears</span><i class="mdi mdi-checkbox-blank-circle"></i><a class="border-right" href="#">Stats</a><i></i><a class="border-right" href="#">Schedule</a><i></i><a href="#">Roster</a></td>
                                    </tr>
                                    <tr class="table-body evens">
                                        <td>
                                            <div class="img-wrapper">
                                                <img  src="${pageContext.request.contextPath}/img/nfl/logo/logo-team.png">
                                            </div>
                                        </td>
                                        <td class="small-text td-divider pd-8 text-center border-right"><span style="padding-right: 8px;">Chicago Bears</span><i class="mdi mdi-checkbox-blank-circle"></i><a class="border-right" href="#">Stats</a><i></i><a class="border-right" href="#">Schedule</a><i></i><a href="#">Roster</a></td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                        <div style="clear:both"></div>
                    </div>
                </div>
                <div id="tabs-2">
                    <p>...</p>
                </div>
                <div id="tabs-3">
                    <p>...</p>
                </div>
                <div id="tabs-4">
                    <p>...</p>
                </div>
                <div style="clear:both"></div>
            </div>
            <div style="clear:both"></div>
        </div>
    
    </jsp:body>
</t:page> 
package com.thbs.data;

public class EmailTemplate {
	public static String verification(String name,String link){
	String EMAIL_VERIFICATION = "<!doctype html>/n"+
			"<html xmlns='http://www.w3.org/1999/xhtml' xmlns:v='urn:schemas-microsoft-com:vml' xmlns:o='urn:schemas-microsoft-com:office:office'>/n"+
			"	<head>/n"+
			"		<meta charset='UTF-8'>/n"+
			"        <meta http-equiv='X-UA-Compatible' content='IE=edge'>/n"+
			"        <meta name='viewport' content='width=device-width, initial-scale=1'>/n"+
			"		<title>Email Verification</title>/n"+
			        
			"    <style type='text/css'>/n"+
			"		p{/n"+
						"margin:10px 0;/n"+
			"			padding:0;/n"+
			"		}/n"+
			"		table{/n"+
			"			border-collapse:collapse;/n"+
			"		}/n"+
			"		h1,h2,h3,h4,h5,h6{/n"+
			"			display:block;/n"+
			"			margin:0;/n"+
			"			padding:0;/n"+
			"		}/n"+
			"		img,a img{/n"+
			"			border:0;/n"+
			"			height:auto;/n"+
			"			outline:none;/n"+
			"			text-decoration:none;/n"+
			"		}/n"+
			"		body,#bodyTable,#bodyCell{/n"+
			"			height:100%;/n"+
			"			margin:0;/n"+
			"			padding:0;/n"+
			"			width:100%;/n"+
			"		}/n"+
			"		#outlook a{/n"+
			"			padding:0;/n"+
			"		}/n"+
			"		img{/n"+
						"-ms-interpolation-mode:bicubic;/n"+
			"		}/n"+
			"		table{/n"+
			"			mso-table-lspace:0pt;/n"+
			"			mso-table-rspace:0pt;/n"+
			"		}/n"+
			"		.ReadMsgBody{/n"+
			"			width:100%;/n"+
			"		}/n"+
			"		.ExternalClass{/n"+
			"			width:100%;/n"+
			"		}/n"+
			"		p,a,li,td,blockquote{/n"+
			"			mso-line-height-rule:exactly;/n"+
			"		}/n"+
			"		a[href^=tel],a[href^=sms]{/n"+
			"			color:inherit;/n"+
			"			cursor:default;/n"+
			"			text-decoration:none;/n"+
			"		}/n"+
			"		p,a,li,td,body,table,blockquote{/n"+
			"			-ms-text-size-adjust:100%;/n"+
			"			-webkit-text-size-adjust:100%;/n"+
			"		}/n"+
			"		.ExternalClass,.ExternalClass p,.ExternalClass td,.ExternalClass div,.ExternalClass span,.ExternalClass font{/n"+
			"			line-height:100%;/n"+
			"		}/n"+
			"		a[x-apple-data-detectors]{/n"+
			"			color:inherit !important;/n"+
			"			text-decoration:none !important;/n"+
			"			font-size:inherit !important;/n"+
			"			font-family:inherit !important;/n"+
			"			font-weight:inherit !important;/n"+
			"			line-height:inherit !important;/n"+
			"		}/n"+
			"		#bodyCell{/n"+
			"			padding:10px;/n"+
			"		}/n"+
			"		.templateContainer{/n"+
			"			max-width:600px !important;/n"+
			"		}/n"+
			"		a.mcnButton{/n"+
			"			display:block;/n"+
			"		}/n"+
			"		.mcnImage{/n"+
			"			vertical-align:bottom;/n"+
			"		}/n"+
			"		.mcnTextContent{/n"+
			"			word-break:break-word;/n"+
			"		}/n"+
			"		.mcnTextContent img{/n"+
			"			height:auto !important;/n"+
			"		}/n"+
			"		.mcnDividerBlock{/n"+
			"			table-layout:fixed !important;/n"+
			"		}/n"+
			"		body,#bodyTable{/n"+
			"			background-color:#FAFAFA;/n"+
			"		}/n"+
				
			"		#bodyCell{/n"+
			"			/border-top:0;/n"+
			"		}/n"+
				
			"		.templateContainer{/n"+
			"			border:0;/n"+
			"		}/n"+
				
			"		h1{/n"+
						"color:#202020;/n"+
			"			font-family:Helvetica;/n"+
			"			font-size:26px;/n"+
			"			font-style:normal;/n"+
			"			font-weight:bold;/n"+
			"			line-height:125%;/n"+
			"			letter-spacing:normal;/n"+
			"			text-align:left;/n"+
			"		}/n"+
				
			"		h2{/n"+
						"color:#202020;/n"+
			"			font-family:Helvetica;/n"+
			"			font-size:22px;/n"+
			"			font-style:normal;/n"+
			"			font-weight:bold;/n"+
			"			line-height:125%;/n"+
			"			letter-spacing:normal;/n"+
			"			text-align:left;/n"+
			"		}/n"+
				
			"		h3{/n"+
						"color:#202020;/n"+
			"			font-family:Helvetica;/n"+
			"			font-size:20px;/n"+
			"			font-style:normal;/n"+
			"			font-weight:bold;/n"+
			"			line-height:125%;/n"+
			"			letter-spacing:normal;/n"+
			"			text-align:left;/n"+
			"		}/n"+
				
			"		h4{/n"+
						"color:#202020;/n"+
			"			font-family:Helvetica;/n"+
			"			font-size:18px;/n"+
			"			font-style:normal;/n"+
			"			font-weight:bold;/n"+
			"			line-height:125%;/n"+
			"			letter-spacing:normal;/n"+
			"			text-align:left;/n"+
			"		}/n"+
				
			"		#templatePreheader{/n"+
			"			background-color:#FAFAFA;/n"+
			"			background-image:none;/n"+
			"			background-repeat:no-repeat;/n"+
			"			background-position:center;/n"+
			"			background-size:cover;/n"+
			"			border-top:0;/n"+
			"			border-bottom:0;/n"+
			"			padding-top:9px;/n"+
			"			padding-bottom:9px;/n"+
			"		}/n"+
				
			"		#templatePreheader .mcnTextContent,#templatePreheader .mcnTextContent p{/n"+
			"			color:#656565;/n"+
			"			font-family:Helvetica;/n"+
			"			font-size:12px;/n"+
			"			line-height:150%;/n"+
			"			text-align:left;/n"+
			"		}/n"+
				
			"		#templatePreheader .mcnTextContent a,#templatePreheader .mcnTextContent p a{/n"+
			"			color:#656565;/n"+
			"			font-weight:normal;/n"+
			"			text-decoration:underline;/n"+
			"		}/n"+
				
			"		#templateHeader{/n"+
			"			background-color:#FFFFFF;/n"+
			"			background-image:none;/n"+
			"			background-repeat:no-repeat;/n"+
			"			background-position:center;/n"+
			"			background-size:cover;/n"+
			"			border-top:0;/n"+
			"			border-bottom:0;/n"+
			"			padding-top:9px;/n"+
			"			padding-bottom:0;/n"+
			"		}/n"+
				
			"		#templateHeader .mcnTextContent,#templateHeader .mcnTextContent p{/n"+
			"			color:#202020;/n"+
			"			font-family:Helvetica;/n"+
			"			font-size:16px;/n"+
			"			line-height:150%;/n"+
			"			text-align:left;/n"+
			"		}/n"+
				
			"		#templateHeader .mcnTextContent a,#templateHeader .mcnTextContent p a{/n"+
			"			color:#2BAADF;/n"+
			"			font-weight:normal;/n"+
			"			text-decoration:underline;/n"+
			"		}/n"+
				
			"		#templateBody{/n"+
			"			background-color:#ffffff;/n"+
			"			background-image:url('https://gallery.mailchimp.com/99dbdd87bb9b47f7477d1ce4b/images/0ad3317e-b328-46bb-a1d6-4bdb1a8cfd5c.jpg');/n"+
			"			background-repeat:no-repeat;/n"+
			"			background-position:center;/n"+
			"			background-size:cover;/n"+
			"			border-top:0;/n"+
			"			border-bottom:2px solid #EAEAEA;/n"+
			"			padding-top:0;/n"+
			"			padding-bottom:9px;/n"+
			"		}/n"+
				
			"		#templateBody .mcnTextContent,#templateBody .mcnTextContent p{/n"+
			"			color:#202020;/n"+
			"			font-family:Helvetica;/n"+
			"			font-size:16px;/n"+
			"			line-height:150%;/n"+
			"			text-align:left;/n"+
			"		}/n"+
				
			"		#templateBody .mcnTextContent a,#templateBody .mcnTextContent p a{/n"+
			"			color:#2BAADF;/n"+
			"			font-weight:normal;/n"+
			"			text-decoration:underline;/n"+
			"		}/n"+
				
			"		#templateFooter{/n"+
			"			background-color:#FAFAFA;/n"+
			"			background-image:none;/n"+
			"			background-repeat:no-repeat;/n"+
			"			background-position:center;/n"+
			"			background-size:cover;/n"+
			"			border-top:0;/n"+
			"			border-bottom:0;/n"+
			"			padding-top:9px;/n"+
			"			padding-bottom:9px;/n"+
			"		}/n"+
				
			"		#templateFooter .mcnTextContent,#templateFooter .mcnTextContent p{/n"+
			"			color:#656565;/n"+
			"			font-family:Helvetica;/n"+
			"			font-size:12px;/n"+
			"			line-height:150%;/n"+
			"			text-align:center;/n"+
			"		}/n"+
				
			"		#templateFooter .mcnTextContent a,#templateFooter .mcnTextContent p a{/n"+
			"			color:#656565;/n"+
			"			font-weight:normal;/n"+
			"			text-decoration:underline;/n"+
			"		}/n"+
			"	@media only screen and (min-width:768px){/n"+
			"		.templateContainer{/n"+
			"			width:600px !important;/n"+
			"		}/n"+

			"}	@media only screen and (max-width: 480px){/n"+
			"		body,table,td,p,a,li,blockquote{/n"+
			"			-webkit-text-size-adjust:none !important;/n"+
			"		}/n"+

			"}	@media only screen and (max-width: 480px){/n"+
			"		body{/n"+
			"			width:100% !important;/n"+
			"			min-width:100% !important;/n"+
			"		}/n"+

			"}	@media only screen and (max-width: 480px){/n"+
			"		#bodyCell{/n"+
			"			padding-top:10px !important;/n"+
			"		}/n"+

			"}	@media only screen and (max-width: 480px){/n"+
			"		.mcnImage{/n"+
			"			width:100% !important;/n"+
			"		}/n"+

			"}	@media only screen and (max-width: 480px){/n"+
			"		.mcnCartContainer,.mcnCaptionTopContent,.mcnRecContentContainer,.mcnCaptionBottomContent,.mcnTextContentContainer,.mcnBoxedTextContentContainer,.mcnImageGroupContentContainer,.mcnCaptionLeftTextContentContainer,.mcnCaptionRightTextContentContainer,.mcnCaptionLeftImageContentContainer,.mcnCaptionRightImageContentContainer,.mcnImageCardLeftTextContentContainer,.mcnImageCardRightTextContentContainer{/n"+
			"			max-width:100% !important;/n"+
			"			width:100% !important;/n"+
			"		}/n"+

			"}	@media only screen and (max-width: 480px){/n"+
			"		.mcnBoxedTextContentContainer{/n"+
			"			min-width:100% !important;/n"+
			"		}/n"+

			"}	@media only screen and (max-width: 480px){/n"+
			"		.mcnImageGroupContent{/n"+
			"			padding:9px !important;/n"+
			"		}/n"+

			"}	@media only screen and (max-width: 480px){/n"+
			"		.mcnCaptionLeftContentOuter .mcnTextContent,.mcnCaptionRightContentOuter .mcnTextContent{/n"+
			"			padding-top:9px !important;/n"+
			"		}/n"+

			"}	@media only screen and (max-width: 480px){/n"+
			"		.mcnImageCardTopImageContent,.mcnCaptionBlockInner .mcnCaptionTopContent:last-child .mcnTextContent{/n"+
			"			padding-top:18px !important;/n"+
			"		}/n"+

			"}	@media only screen and (max-width: 480px){/n"+
			"		.mcnImageCardBottomImageContent{/n"+
			"			padding-bottom:9px !important;/n"+
			"		}/n"+

			"}	@media only screen and (max-width: 480px){/n"+
			"		.mcnImageGroupBlockInner{/n"+
			"			padding-top:0 !important;/n"+
			"			padding-bottom:0 !important;/n"+
			"		}/n"+

			"}	@media only screen and (max-width: 480px){/n"+
			"		.mcnImageGroupBlockOuter{/n"+
			"			padding-top:9px !important;/n"+
			"			padding-bottom:9px !important;/n"+
			"		}/n"+

			"}	@media only screen and (max-width: 480px){/n"+
			"		.mcnTextContent,.mcnBoxedTextContentColumn{/n"+
			"			padding-right:18px !important;/n"+
			"			padding-left:18px !important;/n"+
			"		}/n"+

			"}	@media only screen and (max-width: 480px){/n"+
			"		.mcnImageCardLeftImageContent,.mcnImageCardRightImageContent{/n"+
			"			padding-right:18px !important;/n"+
			"			padding-bottom:0 !important;/n"+
			"			padding-left:18px !important;/n"+
			"		}/n"+

			"}	@media only screen and (max-width: 480px){/n"+
			"		.mcpreview-image-uploader{/n"+
			"			display:none !important;/n"+
			"			width:100% !important;/n"+
			"		}/n"+

			"}	@media only screen and (max-width: 480px){/n"+
				
			"		h1{/n"+
						"font-size:22px !important;/n"+
			"			line-height:125% !important;/n"+
			"		}/n"+

			"}	@media only screen and (max-width: 480px){/n"+
				
			"		h2{/n"+
						"font-size:20px !important;/n"+
			"			line-height:125% !important;/n"+
			"		}/n"+

			"}	@media only screen and (max-width: 480px){/n"+
				
			"		h3{/n"+
						"font-size:18px !important;/n"+
			"			line-height:125% !important;/n"+
			"		}/n"+
			"}	@media only screen and (max-width: 480px){/n"+
				
			"		h4{/n"+
						"font-size:16px !important;/n"+
			"			line-height:150% !important;/n"+
			"		}/n"+

			"}	@media only screen and (max-width: 480px){/n"+
				
			"		.mcnBoxedTextContentContainer .mcnTextContent,.mcnBoxedTextContentContainer .mcnTextContent p{/n"+
			"			font-size:14px !important;/n"+
			"			line-height:150% !important;/n"+
			"		}/n"+
			"}	@media only screen and (max-width: 480px){/n"+
				
			"		#templatePreheader{/n"+
			"			display:block !important;/n"+
			"		}/n"+
			"}	@media only screen and (max-width: 480px){/n"+
				
			"		#templatePreheader .mcnTextContent,#templatePreheader .mcnTextContent p{/n"+
			"			font-size:14px !important;/n"+
			"			line-height:150% !important;/n"+
			"		}/n"+

			"}	@media only screen and (max-width: 480px){/n"+
				
			"		#templateHeader .mcnTextContent,#templateHeader .mcnTextContent p{/n"+
			"			font-size:16px !important;/n"+
			"			line-height:150% !important;/n"+
			"		}/n"+

			"}	@media only screen and (max-width: 480px){/n"+
				
			"		#templateBody .mcnTextContent,#templateBody .mcnTextContent p{/n"+
			"			font-size:16px !important;/n"+
			"			line-height:150% !important;/n"+
			"		}/n"+

			"}	@media only screen and (max-width: 480px){/n"+
				
			"		#templateFooter .mcnTextContent,#templateFooter .mcnTextContent p{/n"+
			"			font-size:14px !important;/n"+
			"			line-height:150% !important;/n"+
			"		}/n"+

			"}</style></head>/n"+
			"    <body>/n"+
			"        <center>/n"+
			"            <table align='center' border='0' cellpadding='0' cellspacing='0' height='100%' width='100%' id='bodyTable'>/n"+
			"                <tr>/n"+
			"                    <td align='center' valign='top' id='bodyCell'>/n"+
			                        
			"                        <table border='0' cellpadding='0' cellspacing='0' width='100%' class='templateContainer'>/n"+
			"                            <tr>/n"+
			"                                <td valign='top' id='templatePreheader'></td>/n"+
			"                            </tr>/n"+
			"                            <tr>/n"+
			"                                <td valign='top' id='templateHeader'></td>/n"+
			"                            </tr>/n"+
			"                            <tr>/n"+
			"                                <td valign='top' id='templateBody'><table border='0' cellpadding='0' cellspacing='0' width='100%' class='mcnTextBlock' style='min-width:100%;'>/n"+
			"    <tbody class='mcnTextBlockOuter'>/n"+
			"        <tr>/n"+
			"            <td valign='top' class='mcnTextBlockInner' style='padding-top:9px;'>/n"+
			              
			"                <table align='left' border='0' cellpadding='0' cellspacing='0' style='max-width:100%; min-width:100%;' width='100%' class='mcnTextContentContainer'>/n"+
			"                    <tbody><tr>/n"+
			                        
			"                        <td valign='top' class='mcnTextContent' style='padding: 0px 18px 9px; font-family: &quot;Comic Sans MS&quot;, &quot;Marker Felt-Thin&quot;, Arial, sans-serif; font-size: 13px; font-style: normal; font-weight: bold;'>/n"+
			                        
			"                            <h1 style='text-align: center;'><em><strong>Welcome to Online Examination</strong></em></h1>/n"+
			"<br>/n"+
			"<br>/n"+
			"&nbsp;/n"+
			"<div style='text-align: center;'><strong>Hi "+name+", Click <a href = '"+link+"'>here</a> to verify your email.</strong></div>/n"+
			"<br>/n"+
			"<div style='text-align: left;'>&nbsp;</div>/n"+

			"<div style='text-align: center;'><br>/n"+
			"&nbsp;</div>/n"+

			"<div style='text-align: center;'><strong>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</strong></div>/n"+

			"<div style='text-align: center;'><br>/n"+
			"<br>/n"+
			"<br>/n"+
			"<br>/n"+
			"&nbsp;</div>/n"+
			"<div style='text-align: left;'>&nbsp;</div>/n"+
			"<br>/n"+
			"<br>/n"+
			"&nbsp;/n"+
			"                        </td>/n"+
			"                    </tr>/n"+
			"                </tbody></table>/n"+
							
			"            </td>/n"+
			"        </tr>/n"+
			"    </tbody>/n"+
			"</table></td>/n"+
			"                            </tr>/n"+
			"                            <tr>/n"+
			"                                <td valign='top' id='templateFooter'><table border='0' cellpadding='0' cellspacing='0' width='100%' class='mcnFollowBlock' style='min-width:100%;'>/n"+
			"    <tbody class='mcnFollowBlockOuter'>/n"+
			"        <tr>/n"+
			"            <td align='center' valign='top' style='padding:9px' class='mcnFollowBlockInner'>/n"+
			"                <table border='0' cellpadding='0' cellspacing='0' width='100%' class='mcnFollowContentContainer' style='min-width:100%;'>/n"+
			"    <tbody><tr>/n"+
			"        <td align='center' style='padding-left:9px;padding-right:9px;'>/n"+
			"            <table border='0' cellpadding='0' cellspacing='0' width='100%' style='min-width:100%;' class='mcnFollowContent'>/n"+
			"                <tbody><tr>/n"+
			"                    <td align='center' valign='top' style='padding-top:9px; padding-right:9px; padding-left:9px;'>/n"+
			"                        <table align='center' border='0' cellpadding='0' cellspacing='0'>/n"+
			"                            <tbody><tr>/n"+
			"                                <td align='center' valign='top'>/n"+
			                                    
			"                                            <table align='left' border='0' cellpadding='0' cellspacing='0' style='display:inline;'>/n"+
			"                                                <tbody><tr>/n"+
			"                                                    <td valign='top' style='padding-right:10px; padding-bottom:9px;' class='mcnFollowContentItemContainer'>/n"+
			"                                                        <table border='0' cellpadding='0' cellspacing='0' width='100%' class='mcnFollowContentItem'>/n"+
			"                                                            <tbody><tr>/n"+
			"                                                                <td align='left' valign='middle' style='padding-top:5px; padding-right:10px; padding-bottom:5px; padding-left:9px;'>/n"+
			"                                                                    <table align='left' border='0' cellpadding='0' cellspacing='0' width=''>/n"+
			"                                                                        <tbody><tr>/n"+
			                                                                            
			"                                                                                <td align='center' valign='middle' width='24' class='mcnFollowIconContent'>/n"+
			"                                                                                    <a href='http://www.twitter.com/' target='_blank'><img src='https://cdn-images.mailchimp.com/icons/social-block-v2/color-twitter-48.png' style='display:block;' height='24' width='24' class=''></a>/n"+
			"                                                                                </td>/n"+
			"                                                                        </tr>/n"+
			"                                                                    </tbody></table>/n"+
			"                                                                </td>/n"+
			"                                                            </tr>/n"+
			"                                                        </tbody></table>/n"+
			"                                                    </td>/n"+
			"                                                </tr>/n"+
			"                                            </tbody></table>/n"+
			"                                            <table align='left' border='0' cellpadding='0' cellspacing='0' style='display:inline;'>/n"+
			"                                                <tbody><tr>/n"+
			"                                                    <td valign='top' style='padding-right:10px; padding-bottom:9px;' class='mcnFollowContentItemContainer'>/n"+
			"                                                        <table border='0' cellpadding='0' cellspacing='0' width='100%' class='mcnFollowContentItem'>/n"+
			"                                                            <tbody><tr>/n"+
			"                                                                <td align='left' valign='middle' style='padding-top:5px; padding-right:10px; padding-bottom:5px; padding-left:9px;'>/n"+
			"                                                                    <table align='left' border='0' cellpadding='0' cellspacing='0' width=''>/n"+
			"                                                                        <tbody><tr>/n"+
			                                                                            
			"                                                                                <td align='center' valign='middle' width='24' class='mcnFollowIconContent'>/n"+
			"                                                                                    <a href='http://www.facebook.com' target='_blank'><img src='https://cdn-images.mailchimp.com/icons/social-block-v2/color-facebook-48.png' style='display:block;' height='24' width='24' class=''></a>/n"+
			"                                                                                </td>/n"+
			"                                                                        </tr>/n"+
			"                                                                    </tbody></table>/n"+
			"                                                                </td>/n"+
			"                                                            </tr>/n"+
			"                                                        </tbody></table>/n"+
			"                                                    </td>/n"+
			"                                                </tr>/n"+
			"                                            </tbody></table>/n"+
			"                                            <table align='left' border='0' cellpadding='0' cellspacing='0' style='display:inline;'>/n"+
			"                                                <tbody><tr>/n"+
			"                                                    <td valign='top' style='padding-right:0; padding-bottom:9px;' class='mcnFollowContentItemContainer'>/n"+
			"                                                        <table border='0' cellpadding='0' cellspacing='0' width='100%' class='mcnFollowContentItem'>/n"+
			"                                                            <tbody><tr>/n"+
			"                                                                <td align='left' valign='middle' style='padding-top:5px; padding-right:10px; padding-bottom:5px; padding-left:9px;'>/n"+
			"                                                                    <table align='left' border='0' cellpadding='0' cellspacing='0' width=''>/n"+
			"                                                                        <tbody><tr>/n"+
			                                                                            
			"                                                                                <td align='center' valign='middle' width='24' class='mcnFollowIconContent'>/n"+
			"                                                                                    <a href='http://mailchimp.com' target='_blank'><img src='https://cdn-images.mailchimp.com/icons/social-block-v2/color-link-48.png' style='display:block;' height='24' width='24' class=''></a>/n"+
			"                                                                                </td>/n"+
			"                                                                        </tr>/n"+
			"                                                                    </tbody></table>/n"+
			"                                                                </td>/n"+
			"                                                            </tr>/n"+
			"                                                        </tbody></table>/n"+
			"                                                    </td>/n"+
			"                                                </tr>/n"+
			"                                            </tbody></table>/n"+
			"                                </td>/n"+
			"                            </tr>/n"+
			"                        </tbody></table>/n"+
			"                    </td>/n"+
			"                </tr>/n"+
			"            </tbody></table>/n"+
			"        </td>/n"+
			"    </tr>/n"+
			"</tbody></table>/n"+

			"            </td>/n"+
			"        </tr>/n"+
			"    </tbody>/n"+
			"</table><table border='0' cellpadding='0' cellspacing='0' width='100%' class='mcnDividerBlock' style='min-width:100%;'>/n"+
			"    <tbody class='mcnDividerBlockOuter'>/n"+
			"        <tr>/n"+
			"            <td class='mcnDividerBlockInner' style='min-width: 100%; padding: 10px 18px 25px;'>/n"+
			"                <table class='mcnDividerContent' border='0' cellpadding='0' cellspacing='0' width='100%' style='min-width: 100%;border-top: 2px solid #EEEEEE;'>/n"+
			"                    <tbody><tr>/n"+
			"                        <td>/n"+
			"                            <span></span>/n"+
			"                        </td>/n"+
			"                    </tr>/n"+
			"                </tbody></table>/n"+

			"            </td>/n"+
			"        </tr>/n"+
			"    </tbody>/n"+
			"</table><table border='0' cellpadding='0' cellspacing='0' width='100%' class='mcnTextBlock' style='min-width:100%;'>/n"+
			"    <tbody class='mcnTextBlockOuter'>/n"+
			"        <tr>/n"+
			"            <td valign='top' class='mcnTextBlockInner' style='padding-top:9px;'>/n"+
			              	
			"                <table align='left' border='0' cellpadding='0' cellspacing='0' style='max-width:100%; min-width:100%;' width='100%' class='mcnTextContentContainer'>/n"+
			"                    <tbody><tr>/n"+
			                        
			"                        <td valign='top' class='mcnTextContent' style='padding-top:0; padding-right:18px; padding-bottom:9px; padding-left:18px;'>/n"+
			                        
			"                            <em>Copyright © 2017 , All rights reserved.</em><br>/n"+
			"<br>/n"+
			"<br>/n"+
			"<strong>Our mailing address is:</strong><br>/n"+
			"noreply.onlineexamination@gmail.com<br>/n"+
			"<br>/n"+
			"Want to change how you receive these emails?<br>/n"+
			"You can <a href='*|UPDATE_PROFILE|*'>update your preferences</a> or <a href='*|UNSUB|*'>unsubscribe from this list</a><br>/n"+
			"&nbsp;/n"+
			"                        </td>/n"+
			"                    </tr>/n"+
			"                </tbody></table>/n"+
			"            </td>/n"+
			"        </tr>/n"+
			"    </tbody>/n"+
			"</table></td>/n"+
			"                            </tr>/n"+
			"                        </table>/n"+
			"                    </td>/n"+
			"                </tr>/n"+
			"            </table>/n"+
			"        </center>/n"+
			"    </body>/n"+
			"</html>/n";
	return EMAIL_VERIFICATION;
}
}
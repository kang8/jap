/*
 * Copyright (c) 2020-2040, 北京符节科技有限公司 (support@fujieid.com & https://www.fujieid.com).
 * <p>
 * Licensed under the GNU LESSER GENERAL PUBLIC LICENSE 3.0;
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.gnu.org/licenses/lgpl.html
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.fujieid.jap.ids.endpoint;

import com.fujieid.jap.ids.model.OidcDiscoveryDto;
import com.fujieid.jap.ids.oidc.OidcUtil;

import javax.servlet.http.HttpServletRequest;

/**
 * OpenID Provider Endpoint
 *
 * @author yadong.zhang (yadong.zhang0415(a)gmail.com)
 * @version 1.0.0
 * @see <a href="https://openid.net/specs/openid-connect-discovery-1_0.html#ProviderMetadata" target="_blank">OpenID Provider Metadata</a>
 * @since 1.0.0
 */
public class DiscoveryEndpoint extends AbstractEndpoint {

    /**
     * OpenID Provider Configuration Response.
     * <p>
     * For multiple users (can be users, organizations, enterprises, etc.), different configurations can be generated through {@code identity}.
     * <p>
     * Such as the following scenario:
     * <p>
     * The issuer of idp is `http://localhost`, and the api in the idp is distinguished according to the user ID.
     * <p>
     *
     * @param request current HTTP request
     * @return OpenID Provider Configuration
     * @see <a href="https://tools.ietf.org/html/draft-ietf-oauth-discovery-06">https://tools.ietf.org/html/draft-ietf-oauth-discovery-06</a>
     * @see <a href="https://openid.net/specs/openid-connect-discovery-1_0.html#ProviderMetadata" target="_blank">OpenID Provider Metadata</a>
     * @see <a href="https://openid.net/specs/openid-connect-discovery-1_0.html#ProviderConfigurationRequest">OpenID Provider Configuration Response</a>
     */
    public OidcDiscoveryDto getOidcDiscoveryInfo(HttpServletRequest request) {
        return OidcUtil.getOidcDiscoveryInfo(request);
    }

    /**
     * Get the public key of the encrypted token (can be used to decrypt the token)
     *
     * <p>
     * For multiple users (can be users, organizations, enterprises, etc.), The public key information of different users can be obtained through {@code identity}.
     * <p>
     * Such as the following scenario:
     * <p>
     * Different users are assigned different keys in the idp system. When the {@code identity} is not empty,
     * <p>
     * the method will first obtain the user's certificate through the {@code identity}, and then generate the public key through the certificate
     *
     * @param identity identity
     * @return public key
     */
    public String getJwksPublicKey(String identity) {
        return OidcUtil.getJwksPublicKey(identity);
    }


}

package com.common;

import com.common.base.ServiceResponse;
import lombok.*;

@Data
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CreateMessageResponse extends ServiceResponse {
    protected static final long serialVersionUID = 1L;
    private Long messageID;
}
